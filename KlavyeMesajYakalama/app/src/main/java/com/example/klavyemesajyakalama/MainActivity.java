package com.example.klavyemesajyakalama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    EditText edt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=(EditText) findViewById(R.id.edttext);
        edt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_BACK){
                    Toast.makeText(context,edt.getText(),Toast.LENGTH_LONG).show();
                    v.setEnabled(false);
                    return true;

                }

                return false;
            }
        });


    }

















/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                Toast.makeText(context,"geri tusuna bastınız",Toast.LENGTH_LONG).show();

                break;

        }

        return super.onKeyDown(keyCode, event);
    }*/
}
