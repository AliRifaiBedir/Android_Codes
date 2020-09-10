package com.example.telefondakiklasrlerilisteleme_arraylistlesnfnagreverileridoldurma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Ekle,Listelemei,idye göre alma,sil,güncelle biz bunları
//yapmak istiyorsak openHelper sınıfından extend(kalıtım) almak gerekiyor.
//Daha sonra implement etmemiz gerekiyor ve sonra constructor olusturcaz
//Amacımız MainAcivtyde çağımak için lazım constructor



public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int database_VERSION = 2;//veritabanı versiyonudur.1 olursa
    //Oncreate çalışır, 2 olursa upgrade çalışır
    private static final String database_NAME = "KitapDB";//database adı
    private static final String table_BOOKS = "kitaplar";//tablo adı
    private static final String book_ID = "id";//alanların adı
    private static final String book_TITLE = "baslik";//alanların adı
    private static final String book_AUTHOR = "yazar";//alanların adı
    private static final String CREAT_BOOK_TABLE = "CREATE TABLE " +
            table_BOOKS + "   ("
            + book_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, "
            + book_TITLE + " TEXT, "
            + book_AUTHOR + " TEXT )";


    private static final String[] COLUMN = {book_ID, book_TITLE, book_AUTHOR};
    //Bunu aşağıda kitapoku metodu için olusturuduk


    //Yukarıda sqlLite olusturup kopyala yapıştır ile işlemleri yaptık


    public SQLiteHelper(@Nullable Context context) {//Burası construcator kısmı
        //(context,databasin ismi,genelde NULL geçilir,1 ve ya 2 kullanılır)
        //Üste sadece context kalsın diğerlerini sil
        //super(context, name, factory, version);
       // super(context, database_NAME, null, database_VERSION);


        super(context,new File(Environment.getExternalStorageDirectory(),database_NAME).toString(), null, database_VERSION);
        //Eğer sd kart üzeinde database olusmasını istiyorsam bunun kullanacam
        Log.i("PATH",Environment.getExternalStorageDirectory()+database_NAME);
        //Bu işlemleri veri tabanı yedek alma için yapıyoruz


        //super(context, String.valueOf(context.getDatabasePath(database_NAME)), null, database_VERSION);
        //Telefonun kendi hafızasında yer alsın istiyorsak bunu kullan


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Veri tabanı ilk açıldığında çağrrılan metoddur
        //Burada genelde tablo olusturma islemlerini yaparız
        db.execSQL(CREAT_BOOK_TABLE);
        //Böylece tabloyu olusturduk


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Herhangi bir şey yapmazsak tablo olduğu gibi gelir
        //genelde güncelleme yapılır.
        db.execSQL("DROP TABLE IF EXISTS " + table_BOOKS);
        //Kitaplar tablosu varsa sil.Tablonun kendisini siler.
        this.onCreate(db);

    }

    public void KitapEkle(Kitap kitap) {
        SQLiteDatabase db = this.getWritableDatabase();//Ekleme ile değişiklik yapacağımız için bunu açıyoruz.
        ContentValues degerler = new ContentValues();//Ekleme,çıkarma,güncelleme için bu sınıfı kullanırız
        degerler.put(book_TITLE, kitap.getBaslik());//Kitap.javadan çağırdık
        degerler.put(book_AUTHOR, kitap.getYazar());//Kitap.javadan çağırdık
        db.insert(table_BOOKS, null, degerler);
        db.close();
        //Böylece ekleme işlemlerini yaptık

    }

    public List<Kitap> kitaplarıGetir() {
        List<Kitap> kitaplar = new ArrayList<>();


        String query = "SELECT * FROM " + table_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Kitap kitap = null;
        //Bu cursor sayesinde bütün kayıtların üzeirnde gezinecek
        if (cursor.moveToFirst()) {//boolean değer dönüyor burda
            do {
                kitap = new Kitap();//Boş kullanmak için constructor içi boş olanı ekleik
                kitap.setId(Integer.parseInt(cursor.getString(0)));
                kitap.setBaslik(cursor.getString(1));
                kitap.setYazar(cursor.getString(2));
                kitaplar.add(kitap);
            } while (cursor.moveToNext());
            //Bunun sayesinde hepsini tek tek dolaştı bilgilerin


        }
        return kitaplar;


    }


    public Kitap kitapoku(int id) {
        //Burada biz id girecez ve geriye dönen değer kitap
        //olduğu için dönüş değerini Kitap yaptık

        SQLiteDatabase db = this.getReadableDatabase();//Secme işlemi için
        Cursor cursor = db.query(table_BOOKS, COLUMN, " id= ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Kitap kitap = new Kitap();
        kitap.setId(Integer.parseInt(cursor.getString(0)));
        kitap.setBaslik(cursor.getString(1));
        kitap.setYazar(cursor.getString(2));
        return kitap;


    }

    public  void kitapSİL(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();//Ekleme ile değişiklik yapacağımız için bunu açıyoruz.
        //delete table where id=id;
        db.delete(table_BOOKS,book_ID+ " =?",new String[]{String.valueOf(kitap.getId())});
        //(tablo,şart ne burası önemli,"=?" olan kısma ne gelecek)
        //Bu şekilde kitap bilgisii siliniyor
        db.close();

        //id ye göre siliyor ve şimdi bunu kullanacaz kitapActiivtyde

    }


    //Geri dönüş değeri etkilenen kayıt sayısıdır
    public int kitapGuncele(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();//Veri ile değişiklik yapacağımız için bunu açıyoruz.
        ContentValues degerler = new ContentValues();//Ekleme,çıkarma,güncelleme için bu sınıfı kullanırız
        degerler.put("baslik",kitap.getBaslik());
        degerler.put("yazar",kitap.getYazar());
        int i =db.update(table_BOOKS,degerler,book_ID+ " =?",new String[]{String.valueOf(kitap.getId())});
        db.close();
        return i;





    }




}