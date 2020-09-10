package com.example.datepickerkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTarihDegistir;
    TextView txtTarih;
    DatePicker dpSonuc;
    StringBuilder sonuc;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTarihDegistir=findViewById(R.id.btnTarihDegistir);
        txtTarih=findViewById(R.id.txtTarih);
        dpSonuc=findViewById(R.id.dpSonuc);
        sonuc=new StringBuilder();

        btnTarihDegistir.setOnClickListener(new View.OnClickListener() {// Butona tıklayınca mevcut tarihih alcaz
            @Override
            public void onClick(View v) {
                sonuc.delete(0,sonuc.length());
                Calendar simdikiZaman=Calendar.getInstance();
                int yıl=simdikiZaman.get(Calendar.YEAR);//Güncel Yılı aldık
                int ay=simdikiZaman.get(Calendar.MONTH);
                int gun=simdikiZaman.get(Calendar.DAY_OF_MONTH);
               /* sonuc.append(gun).append("/").append(ay+1).append("-").append(yıl);//Çünkü ay değeri 0 dan baslıyor
                txtTarih.setText(sonuc.toString());//Mevcut ay,yıl ve günü aldık böylece*/
                //dpSonuc.init(yıl,ay,gun,null);

                //date picker da tarih değistiğinde olacak olayalr
                dpSonuc.init(yıl, ay, gun, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        sonuc.delete(0,sonuc.length());

                        sonuc.append(year).append("/").append(monthOfYear+1).append("-").append(dayOfMonth);
                        //Çünkü ay değeri 0 dan baslıyor
                        txtTarih.setText(sonuc.toString());//Mevcut ay,yıl ve günü aldık böylece
                        //dpSonuc.init(yıl,ay,gun,null);





                    }
                });



            }
        });



    }
}
