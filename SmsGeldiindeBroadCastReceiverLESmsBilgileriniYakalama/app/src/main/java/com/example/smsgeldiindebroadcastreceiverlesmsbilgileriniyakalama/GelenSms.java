package com.example.smsgeldiindebroadcastreceiverlesmsbilgileriniyakalama;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class GelenSms extends BroadcastReceiver {



    //mANİFESSTTE TANIMLAMAYI UNUTMA
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        //getExtras ile intent içinde gönderilen bilgileri alacaz
        //dönen değer bundle olduğu için değişken olusturduk

        //Burda neden byte şeklinde aldık çünkü birden fazal
        //mesaj geldiğinde de çalışssın
        if (bundle != null) {
            //Kısa mesaj içerikleri için pdus paketi çekmek lazık
            Object[] pdus = (Object[]) bundle.get("pdus");
            //Yukarıda dönen değer objectdizisi olduğu için değişken tamamladık
            for (int i=0;i<pdus.length;i++){

                SmsMessage mesaj= SmsMessage.createFromPdu((byte[]) pdus[i]);
                //Böylece sms bilgilerine ulaşabiliyorusz

               String gonNumara= mesaj.getDisplayOriginatingAddress();
               //Gönderen numara
               String msj=mesaj.getDisplayMessageBody();
               //Gelen Mesaj

                Toast.makeText(context,"Gönderici No : "+gonNumara+"\nGönderilen Mesaj"+msj,Toast.LENGTH_LONG).show();


            }



        }


    }
}
