package com.example.edittextlelistviewzerindefiltrelemeyapma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etFilter;
    ListView lst;
    ArrayList<String> list =new ArrayList<>();//ArrayList ekledik
    Context context=this;


    //Aşağıda listeyi hazırladık amacımız EditTEXT içine "a" yazınca iççinde "a" harfi olanlar gelsin
    //içine "ar" yazınca "ar" kelimesi olanlar gelsin.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFilter=findViewById(R.id.etFilter);
        lst=findViewById(R.id.lst);

        list.add("Apple");
        list.add("Samsung");
        list.add("Exper");
        list.add("Casper");
        list.add("Hp");
        list.add("Macintosh");
        list.add("Dell");
        list.add("Lg");

        lst.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.text1,list));
        //Normalde yeni Adapter tanımlayıp daha sonra setAdapter ile adapter eklerdik ama bu şekilde de tanımlanabilir

        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Burada bunu kullanacaz çünkü tam o esnada editText ÜZEİRNDEKİ değişiklikleri yakalama
                //mızı sağlayacak.Burada(CharSequence s : "s" burada edittEXT girdiğimiz harf oluyor)
                ArrayList<String> temptlist =new ArrayList<>();//Burada yeni bir liste olusturduk

                for(int i =0;i<list.size();i++){
                    if(list.get(i).toUpperCase().contains(s.toString().toUpperCase())){
                        //listenin i. elemanını önce büyüğe cevir ve contains ile içerip içermediğine bak
                        //Eğer içeriyorsa tempt liste ekle
                        temptlist.add(list.get(i));

                    }


                }if (temptlist!=null&&temptlist.size()>0){
                    lst.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.text1,temptlist));

                    //Burada yaptığımız şey temptList boş değilse ve uzunluğu sıfırdan büyükse adapter ile ekrana getiriyor sectiğimiz
                    //seyleri gösteriyor ama editTeext boş ise hepsi gözüküyor



                }







            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });








    }
}
