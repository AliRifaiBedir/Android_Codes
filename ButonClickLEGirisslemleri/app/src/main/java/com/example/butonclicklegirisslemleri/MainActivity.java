package com.example.butonclicklegirisslemleri;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    TextView txt;
    Button gönder, sil;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            edt1 = (EditText) findViewById(R.id.EditGirisID);
            edt2 = (EditText) findViewById(R.id.EditSifreID);
            txt = (TextView) findViewById(R.id.textID);
            gönder = (Button) findViewById(R.id.btnGönderID);
            sil = (Button) findViewById(R.id.btnSilID);



            gönder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edt1.getText().toString().equalsIgnoreCase("admin") && edt2.getText().toString().equalsIgnoreCase("12345")) {

                        Toast.makeText(context, "Hoş Geldiniz", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Hatalı Giriş", Toast.LENGTH_SHORT).show();


                    }


                }
            });

            sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edt1.setText("");
                    edt2.setText("");
                    edt2.requestFocus();

                }
            });


        }
    }


