package com.example.androidyazykonumayaevirme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    /*Text to speech sınıfı var ya da ses dosyası şeklinde ü
     kaydetme diye olabilir ve speak diye fonksiyonu
    var.
     */

    //İmplement yaptık onu unutmayalım
    //  <uses-permission android:name="android.permission.INTERNET"/> izni ver

    EditText etGiris;
    Button btnKonus;
    TextToSpeech tts;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnKonus = findViewById(R.id.btnKonus);
        etGiris = findViewById(R.id.etGiris);
        tts=new TextToSpeech(context,this);
        //Başlangıç değerlerini olusturudk

        btnKonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTextToSpeech();
            }
        });


    }

    @Override
    public void onInit(int status) {
        //sTATUS DURUMU BELİRİTİYOR
        if(status==tts.SUCCESS){
           int sonuc= tts.setLanguage(Locale.ENGLISH);
           if (sonuc==tts.LANG_MISSING_DATA|| sonuc==tts.LANG_NOT_SUPPORTED){
               Toast.makeText(context,"Bu Dil Desteklenmiyor",Toast.LENGTH_LONG).show();
           }else {
               convertTextToSpeech();
           }

        }else { Toast.makeText(context,"Başarısız",Toast.LENGTH_LONG).show();

        }

    }
    private void convertTextToSpeech(){
        String text=etGiris.getText().toString();
        if (null==text||"".equals(text)){
            //Text booş ise
            Toast.makeText(context,"Boş Geçmeyiniz",Toast.LENGTH_LONG).show();
            return;

        }
        tts.speak(text,tts.QUEUE_FLUSH,null);
        //(ÇEVİRİLCEK TEXT,KAYIT NASIL OLSUN,NULL)
        //BÖYLECE YAZI KONUŞMAYA ÇEVRİLİYOR


    }
}
