package com.example.androidprogressdialogkullanm_asynctaskilemzikndirirken;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
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
    /*Ayrıca izinleri vermeyi unutma
    <uses-permission android:name="android.permission.INTERNET"/>
       <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"*/


    ProgressDialog pDialog;
    static  final int progress_bar_tipi=0;
    //Bunu yapmamızın sebebi birden fazla prog.dialog olursa
    //sabit bir sayı vererek bunlar arasında id şeklinde ayrım
    //yapmak için


    Button btnMp3Indir;
    static String dosya_url="indirilecek dosya";
    Context context=this;


    /*sya indirirken altta dialog penceresi açılsın ve
mp3 indrirme aşamalrı gözüksün ve tamamı iindiğiginde indirme işelmi bitecek
indirdikce dolacak bir çizgi gibi düşün bunu yapcak şey PROGRESSDİALOG


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
                    new internettenDosyaIndir().execute(dosya_url);
                    //Asenkrontask burda çağırıyoruz
                }




            }
        });


    }

    @Override//Burayı yapmak için oncREATE dışında override yaptık

    //Bunun amacı arka planda inerken kullanıcıya olan indirmeini
    //durumunu göstermek
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case progress_bar_tipi:
                pDialog=new ProgressDialog(context);
                pDialog.setMessage("mP3 Dosya İndiriliyor");
                pDialog.setMax(100);//0 dan başla 100 e kadar gelsin
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//yatay görünüm
                pDialog.setCancelable(false);
                pDialog.show();
                return pDialog;//dönen değerimiz
            default:
                return null;
        }

    }





    //AsyncTask tan kalıtım olustururacz çünkü bu asyncTask Abstrack bi sınıf
    public class internettenDosyaIndir extends AsyncTask<String,String,Object> {
        // AsyncTask<Object,Object,Object>
        //(DOINbACKGROUND PARAMETRESİ,OnprogresUPdate parametresi,OnpostExecute paramtresi)




        @Override
        protected void onPreExecute() {
            //DoındBackground çalışmadan önce çalışacak metod
            super.onPreExecute();

            showDialog(progress_bar_tipi);
            //İndirme işleminden hemen önce göstermek için burda tanımladık
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

                 int dosyaUzunlugu;
                 dosyaUzunlugu=connection.getContentLength();
                 //dosya uzunluğunu başta almak için

                InputStream input=new BufferedInputStream(url.openStream(),10*1024);
                //(InputStrem,10k lık ara beleğe indir dedik)
                //İNput yani dosyayı aldığımız link yani nerden alacaz netten adresi aldık üstte

                OutputStream output=new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/sila.mp3");

                byte[] data=new byte[1024];
                int toplam=0;
                while ((sayi=input.read(data))>0){
                    //İnputun içinde data varsa
                    output.write(data,0,sayi);
                    //Bu şekilde inputtan outputa bütün verileri attık

                    toplam+=sayi;

                    //Uptadete metodunu tetiklemek için bu gerekli
                    publishProgress(String.valueOf((toplam*100)/dosyaUzunlugu));
                    //yüzdelik şekilde göstermek için  ayarıca neden 100 kullanıdk çünkü
                    // pDialog.setMax(100) değerini 100 verdik


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

            dismissDialog(progress_bar_tipi);
            //Böylece dialog kapoandı

            Toast.makeText(context,"Dosya İndirme Tamamlandı Müzik Dinleyebilirsiniz",Toast.LENGTH_LONG).show();


           //müzkDinle()

        }

        @Override
        protected void onProgressUpdate(String[] values) {
            //Sürecin ilerleme miktarını gösteriyor


            pDialog.setProgress(Integer.parseInt(values[0]));
            //İlerleme miktarını göstermek için

        }
    }
}
