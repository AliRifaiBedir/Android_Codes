package com.example.androidgerituualertuygulamas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    //Bu aslında her programda istediğimiz şeylerden biri







    /*Geliştridiğimiz uygulamalrada geri tusuna bir görev
    yapmadığımızda uygulamadan çıkar.Ama biz daha fazla
    kalmasını istiyotyuz uygulamada.

   Şimdi geri tuşuna basıldığında ALERTdİALOG ÇIKACAK VE
   evet tuşuna basarsa çıkacak yoksa kalcak gibi
   bunun sayesinde yanlış cıkıs önlence ve veri
   kaybı önlecenec

   Her hangi bir tasarım yaomayacaz
     */
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //Eğer geri tuşuna basılmışşsa
            AlertDialog.Builder alert=new AlertDialog.Builder(context);
            alert.setTitle("Çıkmak istediğinizden Emin Misiniz")
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Evete tıkalnığında olacak oalyalr
                            finish();

                        }
                    }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Hayıra basılınca olacak oalylar
                    dialog.cancel();
                }
            }).create().show();


        }


        return super.onKeyDown(keyCode, event);
    }
}
