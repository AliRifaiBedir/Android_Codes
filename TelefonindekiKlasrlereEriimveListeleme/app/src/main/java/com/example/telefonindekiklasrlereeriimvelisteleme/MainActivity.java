package com.example.telefonindekiklasrlereeriimvelisteleme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*Butona tıkladığımızda telefon içindeki klasörler listView de
    görüntülensin istiyoruz
     */
    Context context=this;
    ListView listView;
    Button btnListele;
    ArrayList<String> dosyalar=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListele=findViewById(R.id.btnListele);
        listView=findViewById(R.id.listView);
        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              File[] file=  File.listRoots();
              //BUrada file adlı dizi olusturduk file tipinde çünkü
                //listRoots metodu bize dosyalrın ismini döndüyüeüyor
                for (int i=0;i<file.length;i++){
                    File[] directory=file[i].listFiles();

                    //listFİLES: klasör ise içini tamamen sıralıyorum
                    //Dönüş tipi file olduğu için değişken tanımladık
                    //Bütün dosya ve dizinleri atıyorum director

                    for(int j=0;j<directory.length;j++){
                        dosyalar.add(directory[j].getAbsolutePath());
                        //Dosyaları aldık ve arraye ekledik


                    }


                }

                ArrayAdapter<String> adapter= new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,dosyalar);
                listView.setAdapter(adapter);
                //Böylece listView içinde gösteriyoruz.




            }
        });





    }
}
