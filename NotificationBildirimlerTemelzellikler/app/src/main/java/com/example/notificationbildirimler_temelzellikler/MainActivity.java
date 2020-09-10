package com.example.notificationbildirimler_temelzellikler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNotification, btnNotificationSil;
    Context context = this;

    Notification myNotification;
    final String myBlog = "http://www.milliyet.com.tr";

    NotificationManager nManager;//Ekranda göstermek için bunun yaptık
    static final int NOTIFICATION_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotification = findViewById(R.id.btnNotification);
        btnNotificationSil = findViewById(R.id.btnNotificationSil);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            //Tıklandığında bildirim gelmesini istiyoruz
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                //(Conten,sabit değer,intent,flag)

                //Böylece notification içini doldurudk
                myNotification = new Notification.Builder(context).
                        setContentTitle("ANDROID").
                        setContentText("Android İçin text metni ").
                        setWhen(System.currentTimeMillis()).//Bildirim yayınlanacağı tarih
                        setContentIntent(pendingIntent).//Uygulamalar bu sayede uygulamalr
                        //yetkilerini güvenli şekilde daha sonra çalıştırılacak yapılara
                        //devreder.Mesela normalde uygulama kapalı bu sayede bildirime
                        //tıklayınca açıyor gibi

                                setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).//Bildirim sesi
                        //Defauly Vıbrate de yapılabilir
                                setAutoCancel(true).//Bildirim dışına tıklayınca kapansın mı?
                        setSmallIcon(R.mipmap.ic_launcher_round).build();//icon ekledik
                nManager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);

                nManager.notify(NOTIFICATION_ID, myNotification);
                //(Sabit sayı,ve gösterilecek notification)


            }
        });btnNotificationSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nManager.cancel(NOTIFICATION_ID);
            }
        });
    }
}
