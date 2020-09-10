package com.example.haricidepolamaalannaeriim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    /*Öncelikle bunun içiçn izin almak lazım manifest dosyasında
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            //Şu an bunu çalıstırıdğımızda deneme adlı bir klasör olU
            //turacak denemeini adı altına dosya.txt onun içine de bu bir denemedir
            //yazacak
            File dir = Environment.getExternalStorageDirectory();
            //Harici depolama alanına erişim için Environment sınıfı var
            Log.i("File", dir.getAbsolutePath());
            //(String,Dosyamızın yolu)

            File subdir = new File(dir.getAbsolutePath() + "/deneme");
            //Olusturduğumuz dosyaın altına deneme adlı klasör olusturduk atacam
            subdir.mkdir();

            File dosya = new File(subdir, "Dosya.txt");
            //(Hangi subdir ALTINA ALACAK,Dosyanın adı)

            FileOutputStream fos = new FileOutputStream(dosya);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            osw.write("Bu bir denemedir");
            osw.close();
            fos.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
