package com.example.androidmedyaoynatm_sesdosyalarnalmak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.IOException;

import static com.example.androidmedyaoynatm_sesdosyalarnalmak.R.raw.ali;

public class MainActivity extends AppCompatActivity {

    /*Android içinde ses dosyalarını media player ile
    yükelyebiliyoruz.İki tane api var.
    1-Media player ses kaynaklarını oynatmak için
    2-Audio manager ses kaynakalrını yönetmek için

   Bu ses dosyalarını raw klasörü içnden ya da ağ
   üzrinde veri aktarımını yapablriz.AsenkronTask ile
   yapıyoruz bu işlemleri


   Başlangıçta raw klasörü içinde mp3 uzantılı dosyayı atalım
   res içinde Directory içinde raw adlı klasör tanımlıyoruz


     */

    MediaPlayer mediaPlayer;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Uri myUri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/sila.mp3");
        //mediaPlayer=MediaPlayer.create(context, myUri);

        //Bundan sonra manifesste izin vermemiz lazım
        //Üstteki kod harici karttaki media oynatmak için sıla adlı m3 için
        //<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
        //   <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

        //Eğer alltaki kodu siler üstteki kodu yazarsak satır
        //HARİCİ KARTTAKİ sila adlı şarkı çalar


        mediaPlayer=MediaPlayer.create(context, ali);
        //(context,Dosya yolu nerede)Önemli kısmı burası



    }

    public  void btnPlay(View v){
        mediaPlayer.start();


    }
    public  void btnStop(View v){

        mediaPlayer.pause();
    }


}
