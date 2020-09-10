package com.example.customlistview_1_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MobileOs> mobile=new ArrayList<>();
    ListView liste;
    Context context=this;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.liste);
        mobile.add(new MobileOs("IOS"));
        mobile.add(new MobileOs("Windows Phone"));
        mobile.add(new MobileOs("BlackBarry"));
        mobile.add(new MobileOs("Android"));


        //Simdi suctom adepter kullanacaz ve bunun içiçn constructor yapmamız lazım
        //onu da customjavada yapıyoruz.

        CustomAdapter adapter=new CustomAdapter(context,mobile );
        liste.setAdapter(adapter);






    }
}
