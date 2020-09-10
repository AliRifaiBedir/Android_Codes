package com.example.notificationbildirimler_temelzellikler;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationActivity extends AppCompatActivity {
    /*Gelişmiş özellikler için yeni bir
    class olustrduk ve manifesste onu tanıttık
     */
    Context context = this;

    Button btnNotification, btnNotificationSil;
    int numMessage=0;

    NotificationManager nManager;
    NotificationCompat.Builder builder;

    final String myBlog = "http://www.milliyet.com.tr";







    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        final Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        //Bildirimde alarm sesi ne ise o çalacak bunun sayesinde

        final   Bitmap icon= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //Set latge icon için.Bu şekilde resimleri icona cevirdik





        btnNotification = findViewById(R.id.btnNotification);
        btnNotificationSil = findViewById(R.id.btnNotificationSil);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder=new NotificationCompat.Builder(context)
                        .setContentTitle("Başlık")
                        .setContentText("Açıklama")
                        .setLargeIcon(icon)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setSound(alarmSound)
                        .setVibrate(new long[]{100,100,100,100,5000})
                        .setContentIntent(pendingIntent)
                        .setNumber(++numMessage)
                        .setTicker(getResources().getString(R.string.notification_title));
                        //Bildirm gelince yanda çıkacak yazı


                nManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nManager.notify(1,builder.build());


            }
        });


    }
}
