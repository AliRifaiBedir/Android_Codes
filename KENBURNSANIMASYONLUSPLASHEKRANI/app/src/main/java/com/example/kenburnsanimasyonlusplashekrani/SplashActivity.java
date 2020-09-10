package com.example.kenburnsanimasyonlusplashekrani;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {
    //KenBurns image view activyde ekeldik unutma
    // Manifestte bunu tanımla: implementation 'com.flaviofaria:kenburnsview:1.0.6'
    //<activity android:name=".SplashActivity">
    //Uygulamada ilk olarak splshActivity başlayacak unutma manifeastte tanımla

    //KENBURNS DEDEĞİMİZ ŞEY EKRANDA HAREKETLİ FOTO OLMASIDIR UNUTMA

    // <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar"> bunu da unutma
    //böylece ekranın tamamında gözkücek


    KenBurnsView image;
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Uygulamaınn pencere özellikerlini veririz.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Tmel değişkenleri ayarlıyoruz
        //Ful ekran olması için bunları kullandık

        setContentView(R.layout.activity_splash);
        image = findViewById(R.id.imageView);
        String[] appBg = {"first", "second", "third"};
        //Background için 3 tane resimi tanımladık

        int randomId = new Random().nextInt(appBg.length);
        //Bunun sayesinde appBg nin uzunluğunda random sayı üretip randomId atacak
        String rastgelenGelenDeger = appBg[randomId];
        //Böylece buraya atadık o resimlei

        int recourseId = getResources().getIdentifier(rastgelenGelenDeger, "drawable", getPackageName());
        //Hangi resim seçilirse Id ye ulsıyoruz.R.id.sasd gibi yapıyoruz yani

        image.setImageResource(recourseId);
        //böylece image set edildi

        new SayfaGecisi().start();
        //bÖYLECE BU THREAD ÇAĞRILIYOR


    }



    //Burda bizim amacıımız SplashAcTİVİY açılsın 5 sn sonra bizim ana aktiviteye
    //gitsin o yuzden böyle bir class olusturudk Thread kalıtımı aldık

    private class SayfaGecisi extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                //Ekranı 5 sn uyut
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                Intent intent=new Intent(context,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }



}
