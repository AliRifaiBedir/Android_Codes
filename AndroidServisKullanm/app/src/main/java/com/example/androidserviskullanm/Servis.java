package com.example.androidserviskullanm;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Servis extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Timer zamanlayici;
    Handler yardimci;
    static long ZAMAN=10000;//10 snye

    @Override
    public void onCreate() {
        super.onCreate();
        zamanlayici=new Timer();
        yardimci=new Handler(Looper.getMainLooper());
        zamanlayici.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        },0,ZAMAN);
    }

    public void bilgiVer(){
       long zaman= java.lang.System.currentTimeMillis();
        SimpleDateFormat bilgi=new SimpleDateFormat("dd MMMM yyyy, EEEE/ hh:mm");
        final String sonuc=bilgi.format(new Date(zaman));
        yardimci.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Servis.this, sonuc, Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        zamanlayici.cancel();
    }
}
