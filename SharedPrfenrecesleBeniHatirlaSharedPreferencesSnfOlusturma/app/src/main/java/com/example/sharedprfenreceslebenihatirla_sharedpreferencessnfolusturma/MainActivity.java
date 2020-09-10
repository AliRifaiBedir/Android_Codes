package com.example.sharedprfenreceslebenihatirla_sharedpreferencessnfolusturma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    sredPrefernc sredPrefernc;//Bir tane örnekleme aldık
    Context context = this;
    TextView txtHosgeldin;

    //Burada ise kaydettiğimiz veriye karşılayalım elde edelim

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHosgeldin=findViewById(R.id.txtHosgeldin);
        sredPrefernc=new sredPrefernc();

        txtHosgeldin.setText("Hoşgeldin "+sredPrefernc.getValue(this,"username"));
        //Parantez içindeki getValue metoduun dönüş tipi sredPreferc de String olduğu
        //için setText içine yerleşirip elde ettiğmiz veriyi yazdırabildik




    }
}
