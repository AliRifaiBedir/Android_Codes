package com.example.androidbasicactivityzelliklerivemenolusturma;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;



    //CTRL M ile demenü geliyor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Eğer ben toolbarı yorum satırı yaparsam üst kısım gider
        //ve ekran üstü boş gözükür


        //Tollbar şu telefondaki üst taraf oluyor

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.this.setTitle("SnackBar Tıklandı");
                                //Böylece snackbarda bu yazacak


                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Cihazdaki menü tuşuna basıldığında hangi menu gösterilecek
        //onu gösteriyor.
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*Menüdeki ıtemlerin herbirine tıklandığında neler
        yapılacak olana şeyleri yapıyoruz
        item: BURDA AYARLAR,ÇIKIŞ,KAYDET GİBİ MENÜLER(İTEMLER)
        GİBİ ŞEYLER
         */
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        switch (item.getItemId()){//Burada item menüdeki seçenekleri ifade ediyor
            case(R.id.action_settings):
                Toast.makeText(context,"Ayarlar Tıklandı",Toast.LENGTH_LONG).show();
                break;

            case(R.id.action_save):
                Toast.makeText(context,"Kaydet Tıklandı",Toast.LENGTH_LONG).show();
                break;

            case(R.id.action_quit):
                Toast.makeText(context,"Çıkış Tıklandı",Toast.LENGTH_LONG).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
