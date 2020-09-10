package com.example.customlistview_edittextlefiltrelemevemousetklamasnagredeienarkaplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etFilter;
    ListView lst;
    Context context = this;

    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Airport> temptlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFilter = findViewById(R.id.etFilter);
        lst = findViewById(R.id.lst);
        airports.add(new Airport("Atatürk Havalimanı", "AHL", "Istanbul ", "Türkiye", (R.mipmap.ic_launcher_round)));
        airports.add(new Airport("Sabiha Gökcen Havalimanı", "SAW", "Istanbul ", "Türkiye", (R.mipmap.ic_launcher_round)));
        airports.add(new Airport("Adnan Menderes Havalimanı", "ADB", "Izmir ", "Türkiye", (R.mipmap.ic_launcher_round)));
        airports.add(new Airport("Esenboğa Havalimanı", "ESB", "Ankara ", "Türkiye", (R.mipmap.ic_launcher_round)));


        CustomAdapter adapter = new CustomAdapter(airports, context);
        lst.setAdapter(adapter);

        //Şimdi aşaığda geçen derslerde yaptığımız edittext ile filtreleme yapacaz
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temptlist.clear();//Böylece temptlis baslangıcta temiz olacak



                //yUKARIDA geçici temptlist olusturudk
                s = s.toString().toUpperCase();//Buradaki "s" edittext girdiğimiz string
                for (int i = 0; i < airports.size(); i++) {
                    Airport tempPort = airports.get(i);//tempPort yukarıdaki bilgileri barındırıyor
                    if (tempPort.getCountry().toUpperCase().contains(s) ||
                            tempPort.getCity().toUpperCase().contains(s) ||
                            tempPort.getCity().toUpperCase().contains(s) ||
                            tempPort.getCode().toUpperCase().contains(s)) {
                        //İf bloğu içinde karşılastırıyor ve eğer içeriyorsa verilen değeri
                        //temtPort içine atıyor

                        temptlist.add(tempPort);
                    }

                    if (temptlist!=null&&temptlist.size()>0){
                        CustomAdapter adapter = new CustomAdapter(temptlist, context);
                        lst.setAdapter(adapter);



                    }


                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
