package com.example.ratingbarkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar ratingBar;
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar=findViewById(R.id.ratingbarID);
        button=findViewById(R.id.butonID);
        textView=findViewById(R.id.textID);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating)+fromUser);
                //ratingBar.setEnabled(false); //bununla değer girişi sonrası disable yaptık


                //from user(KULLANCI TARAFINDAN GİRİLİRSE TRUE AKSİ HALDE FALSE
                //ratingBAR BAHSİ GEÇEN RATİNG BAR
                //rating ordaki değer hani kaç yıldız işaretli gibi





            }
        });

        button.setOnClickListener(new View.OnClickListener() { // butuna tıklandığında toast mesajında ratingbar değeri geliyor
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_LONG).show();


            }
        });






    }
}
