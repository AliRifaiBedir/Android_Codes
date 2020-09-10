package com.example.girilensredolduundaalanbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    /* Şimdi burda biz edittexe bir sayı girecez
    örneğin 5 girdik ve başlata bastığımzda 5 saniye
    sonra zaman tükendi diyecek ve 2 saniye boyunca
    titreşim yapacaz bunu intent ve broadCast ile
    yapacaz

     <receiver android:name=".MyBroadCastReceiver"/> tanımlamayı unutma

     */


    EditText etTime;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTime = findViewById(R.id.etTime);
    }

    public void btnStart(View view) {
       int i= Integer.parseInt(etTime.getText().toString());
       //Edt değerini aldık

        Intent intent=new Intent(context,MyBroadCastReceiver.class);
        //panding intetn ile yapacaz

        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,1,intent,0);
        //(context,benzersiz bir sayı,,intenttimiz,bir sayı çık gerekli değil)

        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        //Böylece sistemin saatini alabiliyoruz

        alarmManager.set(AlarmManager.RTC_WAKEUP,java.lang.System.currentTimeMillis()+(i*1000),pendingIntent);
        //(Sistem saati,bein belrilediğim saata geleceği saat,Pendingİnten);
        //Saat bizim belirttiğimiz süreye gelince pending intenti yolluyor
        //Yani saniye 5 kaadr bekleyince oendig intenti göderiyor burada

        Toast.makeText(context,"Alarm "+i+" saniyeye kuruldu",Toast.LENGTH_LONG).show();




    }


}
