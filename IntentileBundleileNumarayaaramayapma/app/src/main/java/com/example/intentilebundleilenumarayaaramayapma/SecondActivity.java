package com.example.intentilebundleilenumarayaaramayapma;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SecondActivity extends AppCompatActivity {
    TextView txtnumber;
    Button btnAra;
    Context context=this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        txtnumber = findViewById(R.id.TextviewID);
        btnAra = findViewById(R.id.ButonSecondID);


        Bundle datas = getIntent().getExtras(); // bundle bu şekilde alınır
        txtnumber.setText(datas.getString("no"));// data alındı


        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent ile gelen noyu arayacaz

                if (!txtnumber.getText().toString().equals("")) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+txtnumber.getText().toString()));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(intent);


                }
            }
        });


    }
}
