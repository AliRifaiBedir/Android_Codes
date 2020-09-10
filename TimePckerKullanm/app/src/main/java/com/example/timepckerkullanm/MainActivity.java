package com.example.timepckerkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    /*Saat değistir butonuna bastığımzda
    hem textview hem time pickera saati basalım
      */
    Button btnTime;
    TextView txtTime;
    TimePicker tpSonuc;
    StringBuilder sonuc;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTime = findViewById(R.id.btnTime);
        txtTime = findViewById(R.id.txtTime);
        tpSonuc = findViewById(R.id.tpSonuc);
        sonuc=new StringBuilder();

       /* btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar simdikiZaman = Calendar.getInstance(); //Burada şimdiki saat ve dakika alındı
                int saat = simdikiZaman.get(Calendar.HOUR);
                int dakika = simdikiZaman.get(Calendar.MINUTE);
                sonuc.append(saat).append(":").append(dakika);
                txtTime.setText(sonuc);
                sonuc.delete(0,sonuc.length());

                //Mevcut saati timePickera basalım şimdi

                tpSonuc.setCurrentHour(saat);//saat yazan yerlere kendimizi int değer girebilir
                tpSonuc.setCurrentMinute(dakika);//dakika yazan yerlere kendimiz int değer grbilirz.



            }
        });*/

       tpSonuc.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

           //Burada timepicker değişince değeri txt yazıyoruz farklı olarak

           @Override
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

               sonuc.append(pad(hourOfDay)).append(":").append(pad(minute));
               txtTime.setText(sonuc);
               sonuc.delete(0,sonuc.length());



           }
       });







        }
    public static String pad (int c){

        //Bu fonkiasyon ile eğer pickerdaki
        //10 dan kücük ise başına 0
        //saati gösterecek


        if (c>=10){

            return String.valueOf(c);


        }else{
            return("0"+String.valueOf(c));


        }





    }
}
