package com.example.contextmenu;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;




    /*Bir kontrolün üzerinde elinizi tutunca
    secenek listesi yani menü çıkması olayına context
    menü diyebiliriz kısacca


     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);


        //Simdi edittext için menü seceneği
        //için aşağıdaki kodu yazıyoruz
        //Yani bu view ların menüleri var
        //dememiz lazım
        this.registerForContextMenu(et1);
        this.registerForContextMenu(et2);


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

    @Override// Hangi kontrol hangi menüye sahip kodu
    //Oncreate metodu dışında yazılacak.
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.et1:
                getMenuInflater().inflate(R.menu.renk_menu, menu);//Böylece menü sectik
                break;

            case R.id.et2:
                getMenuInflater().inflate(R.menu.font_menu, menu);
                break;

        }


    }

    @Override
    //Itemlerin herbirine tılandığında neler olacak şimdi onu yapalım
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_blue:
                et1.setTextColor(Color.BLUE);
                break;
            case R.id.mnu_green:
                et1.setTextColor(Color.GREEN);
                break;
            case R.id.mnu_red:
                et1.setTextColor(Color.RED);
                break;

                ////////////// FONT MENUSU ASAGIDA SİMDİ YAPALIM
            case R.id.mnu_big:
                et2.setTextSize(50);
                break;
            case R.id.mnu_medium:
                et2.setTextColor(35);
                break;
            case R.id.mnu_small:
                et2.setTextColor(20);
                break;



        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
