package com.example.dbbrowserforsqliteileoluturlmubirveritabannandroidstudioyaentegreetmek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int database_VERSION = 1;//veritabanı versiyonudur.1 olursa
    static final String DB_PATH = "data/data/com.example.dbbrowserforsqliteileoluturlmubirveritabannandroidstudioyaentegreetmek/";
    static final String DB_NAME = "sozluk.db";
   Context context;
   SQLiteDatabase sqLiteDatabase;


    public DatabaseHelper(@Nullable Context mcontext) {
        //Bizim constructor bu
        super(mcontext, DB_NAME, null, database_VERSION);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Bunları kullanmıyoruz çünkü bunlar zaten veri tabanı yoksa kullanılır
        //Bizim yapacağımız şey veritabanını kopyalayıp elde etmek

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    //Bunları kullanmıyoruz çünkü bunlar zaten veri tabanı yoksa kullanılır
    //Bizim yapacağımız şey veritabanını kopyalayıp elde etmek


    public void createDatabase() throws IOException {
        boolean dbExist = checkDatabase();
        if (dbExist) {
            //database vaesa
        } else {
            getReadableDatabase();
            //Veritabanı daha önce olustuurlmamıs burda veritabanını kopyalıyoruz
            copyDatabase();

        }


    }

    public boolean checkDatabase() {
        //Veritabanı daha önce olustrulmuş mu yoksa olusturulmamış mı?
        //Bunu öğrenmek için
        //Oluşturulmussa trye olusturulmamıssa false değeri döndürür
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public void copyDatabase  () throws IOException {
        //assetin içinden DB_PATH+DB_NAME gidecek
        try {
            InputStream myInput = context.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int lenght;

            while ((lenght = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, lenght);

            }
            myOutput.flush();
            myOutput.close();
            myInput.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void openDatabase()throws  IOException{

        String myPath= DB_PATH + DB_NAME;
        sqLiteDatabase=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
        //Bu şekilde veritabanını açıyoruz

    }

    @Override
    public synchronized void close() {

        if (sqLiteDatabase!= null)
            sqLiteDatabase.close();


        super.close();
    }


    public SQLiteDatabase getSqLiteDatabase(){
        return  sqLiteDatabase;
    }


}








