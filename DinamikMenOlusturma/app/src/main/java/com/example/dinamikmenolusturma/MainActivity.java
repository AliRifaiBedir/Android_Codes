package com.example.dinamikmenolusturma;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*Biz burada şimdi programatik olarak option menu olusturca
    Yani menu kısında xml tarafında değil burda olusturcaz
     */
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
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;

        MenuItem menuItem=menu.add("Dosya");//Burada "Dosya adlı menu olusturuduk
        menuItem.setIcon(R.mipmap.ic_launcher_round);//Burada dosya adlı menüye icon ekledik
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        //Burada int değer dönüyor ve icon için Always OLMASI ŞART

        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            //Burada dosya menüsüne tıkladığımızda olacak şeyleri yazıyoruz
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(context,item.getTitle(),Toast.LENGTH_LONG).show();
                //Buradati item tıkladığımız menü oluyor başlığı gelecek
                // Tıklayınca return saesinde çıkıp gidecek

                return true;
            }
        });

        MenuItem menuItem1=menu.add("Yardım");
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            //Burada yardıma basınca AlertDialog çıksın
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
                //AlertDialog olusturudk
                alertDialog.setMessage(item.getTitle());
                //Burada gettitle ile "yardım  yazısı dönecektir
                alertDialog.setTitle("Seçilen Eleman");
                //Alert DİALOG title ayarladık
                alertDialog.setPositiveButton("Tamam",null );
                //Burada buton ismi "Tamam" oldu ama bi iş yapmayacak
                alertDialog.show() ;//Alert Dialog gösterilecek
                return  true;

            }
        });

        return true;//Bunu ekledik çünkü eğer menülere tıklamazsak hata verecektir.

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
