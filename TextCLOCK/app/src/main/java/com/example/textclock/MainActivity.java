package com.example.textclock;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {
    TextClock textClock1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock1=findViewById(R.id.textClock1);
        textClock1.setFormat24Hour("hh:mm:ss:E");
    }
}
