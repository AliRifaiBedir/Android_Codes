package com.example.androidbroadcastreceiverskullanm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TsunamiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //ONreceive metodu uygulamak zorundayız
        //Bu sınıf çağrıldığında ilk bu çağrılıyor
        //10 saniye içinde işini yapmak zorunda
        //yoksa kapanıyr.Burda ordaki intenti yakalyacaz

        String message = intent.getStringExtra("MESAJ");
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();


    }
}
