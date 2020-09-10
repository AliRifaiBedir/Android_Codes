package com.example.telefondakiklasrlerilisteleme_arraylistlesnfnagreverileridoldurma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KitapActivity extends AppCompatActivity {
    TextView txtBaslik,txtYazar;
    Button btnSil;
    Context context= this;
    SQLiteHelper db;
    EditText txtBaslikD,txtYazarD;


    Kitap seciliKitap;//Böyle bir nesne olusturduk çünkü
    //kitapoku da döne değer Kitap


    /*Burda yaptığımız şey activiy de bastığımımz elemanın
    başlık ve yazar adı gelecek ve listelenece

    Burda sile bsatığımızda MainAcTİVİTY gidcek kitapAdi gözükmeyecek
     */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_kitap);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtYazar=findViewById(R.id.txtYazar);
        btnSil=findViewById(R.id.btnSil);
        db=new SQLiteHelper(context);

        Intent intent=getIntent();
        int id= intent.getIntExtra("kitap",-1);
        seciliKitap=db.kitapoku(id);

        txtBaslik.setText(seciliKitap.getBaslik());
        txtYazar.setText(seciliKitap.getYazar());





    }

    public void btnSil_Click(View v){

        db.kitapSİL(seciliKitap);
        finish();
        //Bunu finish ile yaptık çünkü main activityden
        //buraya startActiviyfor ile geldik yani bir
        //değer ile geri mainActiviy döneceğimiz için finish yazdık





    }


    public void btnGuncelle_Click(){
        //Edittex girilen değerleri güncelleyiruz
        seciliKitap.setBaslik(txtBaslikD.getText().toString());
        seciliKitap.setYazar(txtYazarD.getText().toString()) ;
        db.kitapGuncele(seciliKitap);
        finish();





    }




}
