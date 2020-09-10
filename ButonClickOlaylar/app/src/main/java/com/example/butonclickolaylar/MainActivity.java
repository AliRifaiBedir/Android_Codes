package com.example.butonclickolaylar;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button buton, buton2;
    int sayac = 0;


    public  void init() {
        txt = (TextView) findViewById(R.id.txtID);
        buton = (Button) findViewById(R.id.butonID);
        buton2 = (Button) findViewById(R.id.butonID2);



        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac++;
                txt.setText("Sayac"+sayac);
                txt.setTextColor(Color.CYAN);




            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac--;
                txt.setText("Sayac:"+sayac);
                txt.setTextColor(Color.RED);




            }
        });



    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();




        }

    }



   /* public void onClick(View v){    // birinci yöntem bu şekilde
        switch (v.getId()){

            case R.id.butonID :
                sayac++;
                break;
            case R.id.butonID2:
                sayac--;
                break;

        }
        txt.setText("Sayac:"+sayac);



    }
}
*/