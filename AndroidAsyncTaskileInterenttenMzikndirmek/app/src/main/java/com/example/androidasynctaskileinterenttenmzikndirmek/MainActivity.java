package com.example.androidasynctaskileinterenttenmzikndirmek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button btnMp3Indir;
    static String dosya_url="indirilecek dosya";
    Context context=this;

    /*ASYNCTasc AMACI BİR İŞLEM YAPARKEN ASIL İŞ YANİ ANA AKIŞ
    UZUN SÜRE ENGELLENMESİN.öN PLANDA İŞ YAPILSIN
    BU DİĞER İŞLEMLER ARKA PLANDA İŞİNİ GÖRSÜN
    ÇOK UZUN SÜRMEYEN İŞLEMLER İÇİN KULLANMALIYILIZ
   UZUN İŞLEMLER İÇİN SERVİSLER KULLANILIR*/


    /*Uygulamada harici dosya ya da attığımız yerde mp3 var
    mı ? eğer yoksa indşrme işlemini gerçekleştircek
    indirme işleminden sonra mp3 çalmaya devam edecek
    eğer varsa zaten çalacak
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMp3Indir=findViewById(R.id.btnMP3Indir);
        btnMp3Indir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dosya=new File(Environment.getExternalStorageDirectory().getPath()+"/sila.mp3");
                //Burada harici dosyada olusturacaz ve / çok önemli

                if (dosya.exists()){
                    Toast.makeText(context,"Dosya var Müzik Dinleyin",Toast.LENGTH_LONG).show();
                    //müzikdinle

                }else{
                    Toast.makeText(context,"Dosya yok Lütfen İnternetten Indirin",Toast.LENGTH_LONG).show();
                    //İnternetten dosya indir
                }




            }
        });
    }

    //AsyncTask tan kalıtım olustururacz çünkü bu asyncTask Abstrack bi sınıf
    public class internettenDosyaIndir extends AsyncTask<String,Object,Object>{
        // AsyncTask<Object,Object,Object>
        //(DOINbACKGROUND PARAMETRESİ,OnprogresUPdate parametresi,OnpostExecute paramtresi)




        @Override
        protected void onPreExecute() {
            //DoındBackground çalışmadan önce çalışacak metod
            super.onPreExecute();
        }


        @Override
        protected Object doInBackground(String[] objects) {
            int sayi;
            //yapılcak işler burda yapılaca mesela şimdi
            //müzik indirecez onu bu ksımda yapacaz

            try {
                URL url=new URL(objects[0]);
                URLConnection connection=url.openConnection();
                connection.connect();
                //Böylece bağlantı olusturduk

                InputStream input=new BufferedInputStream(url.openStream(),10*1024);
                //(InputStrem,10k lık ara beleğe indir dedik)
                //İNput yani dosyayı aldığımız link yani nerden alacaz netten adresi aldık üstte

                OutputStream output=new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/sila.mp3");

                byte[] data=new byte[1024];
                while ((sayi=input.read(data))>0){
                    //İnputun içinde data varsa
                    output.write(data,0,sayi);
                    //Bu şekilde inputtan outputa bütün verileri attık


                }
                output.flush();
                output.close();
                input.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }



        @Override
        protected void onPostExecute(Object o) {
            //doınBackGround metodu tamamlandıktan sonra yürütülür
            super.onPostExecute(o);
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            //Sürecin ilerleme miktarını gösteriyor
            super.onProgressUpdate(values);
        }
    }


}
