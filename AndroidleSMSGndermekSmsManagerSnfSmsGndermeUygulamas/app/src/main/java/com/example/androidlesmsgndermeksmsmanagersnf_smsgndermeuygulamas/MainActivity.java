package com.example.androidlesmsgndermeksmsmanagersnf_smsgndermeuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etNumara,etMesaj;
    Button btnSmsYolla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMesaj=findViewById(R.id.etMesaj);
        etNumara=findViewById(R.id.etNumara);
        btnSmsYolla=findViewById(R.id.btnSmsYolla);
        btnSmsYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no=etNumara.getText().toString();
                String mesaj=etMesaj.getText().toString();

               /* Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms"+no));
                //(sendTo,URİ İLE GÖNDERİLECEK SMS NUMARASI)
                //sms.putExtra("sms_body",mesaj); Alttakini değil de böyle yapınca gönderimyior
                //Bu basit anlamında ve intent ile basit oluyor
                sms.putExtra("sms_body","Merhaba Android Kursu Başlıyor");

                startActivity(sms);*/



                SmsManager sms=SmsManager.getDefault();//Örnekleme aldık
               ArrayList<String> lst= sms.divideMessage(mesaj);
               //160 karakterden fazla ise bunu da kullanmak lazım
                //Dönüş tipi arraylsit olduğu için tanım yaptık
                sms.sendMultipartTextMessage(no,null,lst,null,null);
                //Üstteki kod 160 karakterden fazla olunca kullanılan kod yoksa aşağıdaki kod da olur



                //sms.sendTextMessage(no,null,mesaj,null,null);
                //(Gönderilcek numaara,Hizmet Numarası,mesajımı,pandingIntent,PnadiigIntent)
                //Burada manifesste izin ver  <uses-permission android:name="android.permission.SEND_SMS"/>




            }
        });
    }
}
