package com.example.broadcastreceiverileguncelpildurumu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Aşağıda yaptığımız şekilde bunu manifesstte
    tanımlamaya gerek yok manifestte normalde
    action falan yapıyorukduk ama baryı kbunun sayesinde yapmaya gere
    kyok



     */
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.TxtView);

        IntentFilter batteryLevel = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver,batteryLevel);
        //(yapılacak iş,İNTENT FİLTER)




    }

    //Burada harici değilde broaCast burda olusturudk
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            txtView.setText("Şu anki pil seviyesi : "+level+" %");

            //Bu şekide anlık pil seviyesini aldık
            //Şimdi buna Broadcasta ulasacaz yuarıda

        }
    };
}
