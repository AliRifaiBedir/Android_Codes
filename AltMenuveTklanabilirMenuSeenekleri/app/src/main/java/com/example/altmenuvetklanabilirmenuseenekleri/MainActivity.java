package com.example.altmenuvetklanabilirmenuseenekleri;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.SubMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /*
        Burada programatik olarak "SubMenu"olusturudk
        ve üstteki getInf. kodunu yorum yapıp bunları ekledık

        SubMenu filemenu= menu.addSubMenu("File");
        filemenu.add(0,1,1,"Add");
        filemenu.add(0,Menu.FIRST,0,"Save");
        filemenu.add(0,Menu.FIRST+1,0,"Edit");
        SubMenu editmenu=menu.addSubMenu("Edit");
        editmenu.add(1,1,1,"Delete");

         */

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mahalleler_sub1_sub1) {
            Toast.makeText(context,item.getTitle(),Toast.LENGTH_LONG).show();
            return true;
        }else if (id==R.id.mahalleler_sub1){
            item.setChecked(true);
        }
        else if (id==R.id.mahalleler_sub2){
            if(item.isChecked()){
                item.setChecked(false);
            }else{

                item.setChecked(true);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
