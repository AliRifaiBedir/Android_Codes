package com.example.programatikmenuelemanlarnadngleeriim;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AyarlarActivty {
    Context context=this;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ArrayList<String> menuItem = new ArrayList<>();//Array list olusturudk
        menuItem.add("File");
        menuItem.add("Edit");
        menuItem.add("Window");
        menuItem.add("Help");
        menuItem.add("About");

        for (String t : menuItem) {//For each ile ulasacaz
            MenuItem menuItem1 = menu.add(t);//Burda add ile dönen değer
            //menuItem olduğu için değişkene atadık
            menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(context,item.getTitle(),Toast.LENGTH_LONG).show();
                    return true;
                }
            });



        }
        return super.onCreateOptionsMenu(menu);

    }





}
