package com.example.countdowntimerleprogressdialoguygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start,stop;
    TextView text;
    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.startTimer);
        stop=findViewById(R.id.stopTimer);
        progressBar=findViewById(R.id.progressBar);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer=new MyCountDownTimer(10000,1000);
                myCountDownTimer.start();


            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                myCountDownTimer.cancel();




            }
        });


    }

    //Biz bir class olusturudk ve kalıtım aldık CouNdownTimerdan
    //İmplement ve consturctır yaptık çünkü altı kızardı
    public class MyCountDownTimer extends CountDownTimer{
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress= (int) (millisUntilFinished/1000);//10 9 8   2  1

            //Burda progressbar max değeri 10 verdik xml de
            progressBar.setProgress((progressBar.getMax()+1)-progress);//1 2 3
            //BuNUN SAYESİNDE 1 DEN BAŞLAYACAK


        }

        @Override
        public void onFinish() {

        }
    }


}
