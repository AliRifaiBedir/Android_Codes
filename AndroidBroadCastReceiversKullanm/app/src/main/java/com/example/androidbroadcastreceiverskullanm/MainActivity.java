package com.example.androidbroadcastreceiverskullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*Projemize yerleştirdiğimzde sistem tarafıdnan
    bizi uyarması diyebilirz
    Mesela pil 100 de 15 kalınca bizi uyarması gibi
    vb diyebilr
    Aslında bu da bir intenttir
     */


    /*Broadcast sınıfımda bişey yapmak için bir
    tane sınıf olusturuyoruz.Yani işi yapacak yer
    Şimdi biz TsunamiReceiver diye bir sınınf olustrcaz


     */


    Button broadcastGonder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastGonder=findViewById(R.id.broadcastGonder);
        broadcastGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("Benzersiz Bir İsim Olacak");
                //İçeride yazılacak olan şeyi manifesste tanımladık
                //benzersiz bir isim olması lazım.
                //activityde action altında tanımladık dikktali ol
                intent.putExtra("MESAJ","Evinizi Terk Edin");
                sendBroadcast(intent);//Bunla yolladık
                //Benzer Bir İsim OLlacak bakacak sonra manifesste
                //bunu broadcast olduğunu anlayıp işi yapcak


            }
        });
    }
}
