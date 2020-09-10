package com.example.androidregularactivitykullanmolaanetkinlik_158ders;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*Uygulamanın normal iş akışı sırasında olusturulan
    bilidirimlerdir.Geri tuşuna duyarlı oluyor.Burda
    şimdi bir bildrim var buna tıklayınca başka bir akti
    viteye gidiyrouz sonra o aktivitide geri tuşuna basınca
    tekrardan ana sayfaya dönen bir uygulama yapacaz
     */
    //İkinci ekran olarak Notifavion adlı java dosyası açtık
    /* <activity android:name=".Notification"
            android:parentActivityName=".MainActivity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity"/>

        MainACTİVİYY PARÇASI OLDUĞU İÇİN BU ŞEKİLDE MANİFESSTE TANIMLA

                */


    Button btnNotification,btnNotificationSil;
    NotificationCompat.Builder notification;//Bildirim olusturmak için
    NotificationManager notificationManager;//Bildirimi göstermek için

    Context context=this;
    static  final int Notification_ID=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotification=findViewById(R.id.btnNotification);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btnNotificationSil=findViewById(R.id.btnNotificationSil);
        btnNotification.setOnClickListener(new View.OnClickListener()


        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override

            public void onClick(View v) {
                //Aşağıdaki 5 satır burda en son yapılacak
                Intent resultIntent=new Intent(context,Notification.class);
                //contenxtten diğer activiy gidecek
                TaskStackBuilder stackBuilder=TaskStackBuilder.create(context);
                //Arka yığın olusturudk
                stackBuilder.addParentStack(Notification.class);
                //Hangi arka yığın eklenecek
                stackBuilder.addNextIntent(resultIntent);
                //İntent olusturmamız lazım
                PendingIntent resultpendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                //(kod,flag)


                notification= new NotificationCompat.Builder(context)
                        .setContentTitle("Başlık")
                        .setContentIntent(resultpendingIntent)
                        .setContentText("Mesaj İçeriği")
                        .setSmallIcon(R.mipmap.ic_launcher);
                notificationManager.notify(Notification_ID,notification.build());
            }
        });
    }
}
