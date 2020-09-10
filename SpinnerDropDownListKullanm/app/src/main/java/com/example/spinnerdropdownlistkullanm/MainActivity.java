package com.example.spinnerdropdownlistkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    Spinner spinner_1,spinner_2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_1 = findViewById(R.id.spinner_1);
        spinner_2 = findViewById(R.id.spinner_2);
        ArrayList<String> liste=new ArrayList<>();//Buradaki amacımız spinner 2 de
        //AŞAĞIDAki takım listesini göstermek istiyoruz ama Adaptor olusturmadan olmuyor
        liste.add("Besiktaş");
        liste.add("Fenerbahce");
        liste.add("Galatasaray");
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,liste);
        //(context,Kullanıcıın göreceği listenin yerleşim biçimi,hangi diziyi gösterecek)

        spinner_2.setAdapter(dataAdapter);






        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Oradaki Itemler secildiğinde secilecek olayalr
            //Burada iki tane override metod geldi
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Secilen Eleman :" + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                //Tıkladığımız elemanı bu şekilde yakalıyoruz

                Toast.makeText(context, "Secilen Eleman :" + parent.getItemIdAtPosition(position), Toast.LENGTH_LONG).show();
                //Secili elemaının sırasına böyle ulasıyoruz


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Hiç BİR eleman secili değilse yapılacak metod

            }
        });


    }

    public  void btnEkle(View v){

        Toast.makeText(context,"Secili eleman:"+spinner_2.getSelectedItem(),Toast.LENGTH_LONG).show();

        //getSELECTEDıTEM İLE VERİYİ ALMIŞ OLDUK
        //Dönüş tipi string olmadığı için başına secili eleman yazdık





    }



}
