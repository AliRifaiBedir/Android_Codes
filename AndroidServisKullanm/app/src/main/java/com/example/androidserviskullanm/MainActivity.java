package com.example.androidserviskullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*Servis uygulamanın ana uygulamada default oalrak
    çalışır.Genel mantık işlemleri başlataacak ve bitircek
    tredi servis içerisnde yaratıp çalıştaraaksın.Uygulama servise
    gelcek ve işi yapcak.uYGULAMADA BİR ARAYÜZE SAHİP DEĞİL YANİ KULllanıcyla
    etkileşim içinde değil.Ne zaaman kullanılır internetter veri indirme,güncelleme
    gibi uzun vadeli işler için

     */

    /*Biz şimdi burada buton ile servisi başlat dicez ve sistemin
    güncel saatini alaak ve 10 saniyede bir Toast olarak arka planda gönderecek
    Biz burda nasıl çalıştığını görmeyecez

    Servis başlat adlı butona bastığımızda dahas onra onun adını servis kapat
    adı olarak değişecek.sTART STOP MANTIĞI
     */

    //Servis için bir tane clss olusturduk.Burada işlemleri
    //başlatacak ve bitircek tredleri yapacaz



    Button btnServis;
    Context context=this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnServis=findViewById(R.id.btnServis);
    }

    public boolean ServisCalisiyorMu(){
        ActivityManager servisTöneticisi= (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo servis:servisTöneticisi.getRunningServices(Integer.MAX_VALUE)){
            if (context.getPackageName().equals(servis.service.getPackageName())){
                return true;
            }
        }
        return false;

    }



    public void btnServis_Click(View v){
        Button button= (Button) v;
        if (ServisCalisiyorMu()){
            stopService(new Intent(context,Servis.class));
            ((Button) v).setText(getString(R.string.btnBaslat));
        }else{
            startService(new Intent(context,Servis.class));
            ((Button) v).setText(getString(R.string.btnDurdur));


        }

    }


}
