package com.example.listactivtykullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    //Androidde liste tabanlı ekranları yapmak içiçn kullanılır
    //İçerisinde gömülü ListvİEW VARDIR
    //extend ListActivty yapmayı unutma
    String os[];
    ArrayAdapter<String> adp;
    Context context=this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);(Buna gerek yok silebilirz)
        os=new String[5];
        os[0]="Solaris";
        os[0]="Pardus";
        os[0]="Ubuntu";
        os[0]="MacOS";
        os[0]="Linux";

        adp=new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,android.R.id.text1,os);
        setListAdapter(adp);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Herbir elemena tıkladığımızda olacak olaylar için metodumuz
        //(v:satırda gösterilen eleman,position:elemanın sırası,id:id)

        Toast.makeText(context,os[position],Toast.LENGTH_LONG).show();
        super.onListItemClick(l, v, position, id);
    }
}
