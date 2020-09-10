package com.example.androidseskaydetmeveoynatma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    /*Kayıt başlat deyince kaydetme işini başaltacaz
    Kayıt durdur deyince durduracaz
    Eğer oynat dersek kaydı dinleyecez durdur
    dersek durduracaz kayıdı

    KayıtBaşlatmak ve durdurmak için:Media Recorder sınfı
    Oynatmak ve durdurmak için :MediaPlayer

     */

    MediaRecorder mRecorder;//KAYIT ALMAK İÇİN
    MediaPlayer mPlayer;//KAYITLARI DİNLEMEK İÇİN
    String cikisDosyasi=null;//Dosyamızı nereye kaydetmek için
    Context context=this;
    /*
      <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>

    Bu izinleri vermeyi unutma
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cikisDosyasi= Environment.getExternalStorageDirectory().getAbsolutePath()+"/kayit.3gp";
        //   <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> izin ver
        //hARİİCİ KARTA KAYDEDECEĞİMİZİ İLERDE SÖYLEMEK İÇİN BUNU YAPTIK

        mRecorder=new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //Mikrofondan kayıt edecez diyoruz

        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //Kaydımızn sıkıştırma şekli

        mRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        //Kullanılacak codec değerleri

        mRecorder.setOutputFile(cikisDosyasi);
        //Nereye kayıt edecez
    }
    public void btnKayitBaslat(View v){
        //Yukarıda tanımladığımız şeyleri hazırılıyor
        try {
            mRecorder.prepare();
            mRecorder.start();
            Toast.makeText(context,"Kayıt Başlamıştır",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void btnKayitDurdur(View v){
        mRecorder.stop();
        mRecorder.release();
        //İşlem bittikten  sonra içeriği temizlemek için
        mRecorder=null;//Bunu yapmak gerekiyor
        Toast.makeText(context,"Kayıt Durduruluyor",Toast.LENGTH_LONG).show();


    }
    public void btnKayit(View v){
        mPlayer =new MediaPlayer();//Nesne olusturduk
        try {
            mPlayer.setDataSource(cikisDosyasi);//Hangi kaynak oynatılacak
            mPlayer.prepare();
            mPlayer.start();
            Toast.makeText(context,"Kayıt Oynatılıyor",Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void btnDurdur(View v){
        //Realese den sonra sorgu yapmamız lazım
        if (mPlayer!=null){
            mPlayer.stop();
            mPlayer.release();
            mPlayer=null;//Serbest bıraktık
            Toast.makeText(context,"Kayıt Oynatımı Durduruluyıor",Toast.LENGTH_LONG).show();
        }

    }


}
