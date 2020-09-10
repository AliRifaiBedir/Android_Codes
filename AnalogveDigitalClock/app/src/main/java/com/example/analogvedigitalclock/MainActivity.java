package com.example.analogvedigitalclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DigitalClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DigitalClock digitalClock;
    Context context=this;
    // Digital clock tıklayınca toast mesajı yayınlattık

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digitalClock=findViewById(R.id.DigitalClock);
        digitalClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,digitalClock.getText(),Toast.LENGTH_LONG).show();



            }
        });




    }
}
