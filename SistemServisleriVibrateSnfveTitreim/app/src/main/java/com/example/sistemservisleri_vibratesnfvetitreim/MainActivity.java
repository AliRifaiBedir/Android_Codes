package com.example.sistemservisleri_vibratesnfvetitreim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonVibrate1,buttonVibrate2,buttonVibrate3;
    Vibrator vibrator;//Bu sınıftan örnekleme almam lazım
/*<uses-permission android:name="android.permission.VIBRATE" />

Manifest dosyasına bunu yazmayı unutma
 */





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Context. deyince bir çok servis geliyor biz vibrator seciyoruz

        buttonVibrate1=findViewById(R.id.buttonVibrate1);
        buttonVibrate2=findViewById(R.id.buttonVibrate2);
        buttonVibrate3=findViewById(R.id.buttonVibrate3);

        buttonVibrate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Yarım saniye titretmesi yapacaz

                vibrator.vibrate(500);



            }
        });

        buttonVibrate2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                if (action==MotionEvent.ACTION_DOWN){
                    vibrator.vibrate(1000);


                }else if (action==MotionEvent.ACTION_UP){
                    vibrator.cancel();

                }


                return true;
            }
        });



        buttonVibrate3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                if (action==MotionEvent.ACTION_DOWN){
                    long[] pat={100,100,100,100,5000};
                    //Gecikme,titreştir,gecikme,titreştir,on-of
                    vibrator.vibrate(pat,0 );
                    //-1 hariç sürekli tekrar eder


                }else if (action==MotionEvent.ACTION_UP){
                    vibrator.cancel();

                }
                return true;
            }
        });




    }
}
