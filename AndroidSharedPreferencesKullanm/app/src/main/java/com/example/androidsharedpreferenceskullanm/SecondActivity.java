package com.example.androidsharedpreferenceskullanm;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Files;

public class SecondActivity extends AppCompatActivity {
    //Manifest dosyasına eklemeyi unutma


    TextView text;
    sredPrefernc sredPrefernc;
    Context context=this;
    String donenDeger;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Orda kaydettiğmiz değer burda elde ediyoruz


        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        text = findViewById(R.id.text);
        sredPrefernc =new sredPrefernc();
       donenDeger= sredPrefernc.getValue(context );
       text.setText(donenDeger);


    }
}
