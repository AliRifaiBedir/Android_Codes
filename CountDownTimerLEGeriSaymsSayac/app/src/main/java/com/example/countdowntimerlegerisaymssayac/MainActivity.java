package com.example.countdowntimerlegerisaymssayac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        countDownTimer=new CountDownTimer(100000,2000) {
            //(toplam süre,hangi aralıklarala tetiklencel)
            //Toplam 10 saniye sürsun ve  her ik saniyede 1 tetiklensin dedik yukarıda
            @Override
            public void onTick(long millisUntilFinished) {
                //Her tetiklendiğinde yapılmasını isteğimiz şeylrer
                //yani 2 saniyede bir biizm kodda
                text.setText("Kalan Süre : "+millisUntilFinished/1000);
                //Saniye cinsinden göstersin diye 1000 böldük
                //10  8  6  4 gibi olacak yani

            }

            @Override
            public void onFinish() {
                //İş bittiğinde
                text.setText("Ok");

            }
        }.start();


    }
}
