package com.example.stilolusturma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txt= (TextView) findViewById(R.id.diziID);
        Resources res=this.getResources(); // kaynaklara ulstık
       int dizi[]=res.getIntArray(R.array.dizi);//diziyi atadık


       int toplam=0;

       for(int i =0;i<dizi.length;i++){
           toplam=toplam+=dizi[i];

       }


       txt.setText(String.valueOf(toplam));








    }
}
