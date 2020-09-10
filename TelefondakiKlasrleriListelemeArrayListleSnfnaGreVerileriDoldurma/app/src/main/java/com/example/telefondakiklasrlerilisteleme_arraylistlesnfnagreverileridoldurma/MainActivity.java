package com.example.telefondakiklasrlerilisteleme_arraylistlesnfnagreverileridoldurma;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listemiz;
    Context context = this;
    List<Kitap> list;
    EditText txtBaslikDE, txtYazarDE;

    //Şimdi Kitap.java olusturacaz

    static final String DB_PATH = "/storage/emulated/0/";
    static final String DB_NAME = "kitapDB";

    SQLiteHelper db = new SQLiteHelper(context);//db olusturduk

    ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBaslikDE = findViewById(R.id.txtBaslikDE);
        txtYazarDE = findViewById(R.id.txtYazarDe);
        listemiz = findViewById(R.id.listemiz);


        //BU KOD sayesinde her uygulama açılfığında tablo silinir
        //veilk başta olan tablo tekrardan açılıyor yani güncellesen bile
        //ilk olusturduğun tablo geliyor
        //şimdi bundan dolayı yorum satırı yapacaz
        //db.onUpgrade(db.getWritableDatabase(),1,2);

        db.getWritableDatabase();//bÖYLECE üstteki durum yaşanmayacak
        //veriler silinmeyecek ve versiyon=2 olacak
        db.KitapEkle(new Kitap("Çalıkuşu", "Reşat Nuri Güntekin"));
        db.KitapEkle(new Kitap("Pi", "Akillah Azra Kohen"));
        db.KitapEkle(new Kitap("Çılgın Türkler Kıbrıs", "İpek Ongun"));
        db.KitapEkle(new Kitap("Piraye", "Canan Tan"));

        //Üstteki KitapEkle metodu doğru değil çünkü
        //her açılıp kapandığında bunları otomatik olarak ekleycek
        //doğru olan yöntem   public  void btnEkle_Click(View v){//Android dinamik veri ekleme
        //metodu şle yaptığımız


        list = db.kitaplarıGetir();

        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listBaslik.add(i, list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<>(context, R.layout.satir_layout, R.id.listMetin, listBaslik);
        listemiz.setAdapter(mAdapter);


        //Bu kısım inten ile diğer kİTAPActivvty id  göndermek için
        //yapıldı daha sonra o ID ile karşı taraftan yakalayıp
        //işlemlerimizi yapacağız.Bu yakalamayı SQLiteHelperda yapacaz
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, KitapActivity.class);

                intent.putExtra("Kitap", list.get(position).getId());
                //Tıkladığımız itemin ID sini list.get(position)ile elde ettik
                Log.i("idimiz", String.valueOf(list.get(position).getId()));
                startActivityForResult(intent, 1);


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Anlık değişimi sağlayan yer burasu


        //Silme işlemi sonrası refresh yapmak için
        //Yani geriye 4 kitap kalıyorsa o kaldırlmış olacak
        list = db.kitaplarıGetir();

        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listBaslik.add(i, list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<>(context, R.layout.satir_layout, R.id.listMetin, listBaslik);
        listemiz.setAdapter(mAdapter);


        super.onActivityResult(requestCode, resultCode, data);
    }

    public void btnEkle_Click(View v) {//Android dinamik veri ekleme
        String baslıkIsmi = txtBaslikDE.getText().toString();
        String yazarIsmi = txtYazarDE.getText().toString();
        db.KitapEkle(new Kitap(baslıkIsmi, yazarIsmi));
        //Burada ekleme yapıyoruz


        //Burada güncelleme yapıyoruz
        list = db.kitaplarıGetir();
        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listBaslik.add(i, list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<>(context, R.layout.satir_layout, R.id.listMetin, listBaslik);
        listemiz.setAdapter(mAdapter);


    }

    public void btnYedekAl_Click(View v) throws IOException {
        String inFileName = DB_NAME + DB_PATH;
        File dbFile = new File(inFileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inFileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Böylece dosyamızı tanımlayıp nereden alacapını yaoıtk

        //Şimdi nereye atılacağanı yapıyoruz
        String outFileName= Environment.getExternalStorageDirectory()+"/database_copy.db";
        //Burada üstteki yerden dbFileden al dataabe_copy at

        OutputStream myOutput = null;

        try {
            myOutput = new FileOutputStream(outFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Andoridde parça parça atıyoruz ve bu şekilde
        byte[] buffer= new byte[1024];
        int lenght;
        try {
            while ((lenght = fis.read(buffer)) > 0) {
                myOutput.write(buffer,0,lenght);

            }
        }catch (IOException e){

            e.printStackTrace();
        }
        myOutput.flush();
        myOutput.close();
        fis.close();





    }







    }





