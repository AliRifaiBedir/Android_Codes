package com.example.ntentkullanimi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnsiteyeGİT, butongeri;
    Context context=this;
    TextView txtgelendeger;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent=getIntent(); // Ordaki intentti yakalamaya çalıyorz
       String ad= intent.getStringExtra("isim"); // bir ekrandan bir ekrana geçerken veri yakalama özelliği kullandık
        String sifre=intent.getStringExtra("sifre");
       txtgelendeger.setText("hosgeldin"+ad+"\nsifreniz :"+sifre);

        txtgelendeger=findViewById(R.id.txtID);
        btnsiteyeGİT=findViewById(R.id.SiteyeGİT);
        butongeri=findViewById(R.id.btnGERİ);
        btnsiteyeGİT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);//NEREYE GİDECEK YANİ // görüntülümeyle ilgili bişey yapacağımız için VIEW SECTİK
                intent.setData(Uri.parse("http://google.com.tr"));//İÇİNE GİREN STRİNGİ URİ YANİ ADRESE LİNKE DÖNDÜRDÜ
                startActivity(intent);
            }
        });

        butongeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(context,MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
