package com.example.listview_spinnerseilenlkeyegrellerlisteleniyor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spnCountries;
    ListView lstCities;
    Context context=this;




    // 3-4 tane ülke seçecez ve bunları spinnera atacaz secilen ülkeye göre 2 -3 tane şehri listview de
    //sergileyecez.Bunu yaparken metod ile yapacaz



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCountries=findViewById(R.id.spnCountries);
        lstCities=findViewById(R.id.lstCities);
        spnCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //SpnCountries içinde herhangi bir seçim yaptığımızda olacak olan metod
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //(Spinerdaki secili eleman:parent)

              String secilenUlke=  spnCountries.getItemAtPosition(position).toString();
              //Burada secilenülke  adlı değişkene atıyoruz

                ArrayAdapter<String> adapter=new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,android.R.id.text1,sehirGelsin(secilenUlke));
                //Burada klasik adepter kullanıp yazdırıcaz

                lstCities.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }


    ArrayList<String> sehirGelsin(String ulke){//Geriye arraylist döndüreceğimiz metod
        ArrayList<String> sehirler=new ArrayList<>();
        switch (ulke){
            case "Türkiye":
                sehirler.add("Ankara");
                sehirler.add("İstanbul");
                sehirler.add("İzmir");

                break;
            case "Almanya":
                sehirler.add("Berlin");
                sehirler.add("Hamburg");
                sehirler.add("Girne");

                break;
            case "KKTC":
                sehirler.add("Magusa");
                sehirler.add("Lefkosa");
                sehirler.add("Girne");

                break;

        }
        return  sehirler;




    }

}
