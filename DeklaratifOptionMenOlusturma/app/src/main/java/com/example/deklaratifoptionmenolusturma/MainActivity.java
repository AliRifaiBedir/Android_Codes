package com.example.deklaratifoptionmenolusturma;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this    ;

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
    public boolean onCreateOptionsMenu(Menu menu) {//Yani option menunun olustugu yer
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);//Hangi menü çalısaksa onu seciyorz
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /* Menü itemlerine dokunduğumda ne yapacağımızı
        burda yapıyoruz

        Burada item diye geçen yazı paramatre oluyor unutma

         */

        switch (item.getItemId()){
            /*case(R.id.action_settings):
                Toast.makeText(context,"Ayarlar Tıklandı",Toast.LENGTH_LONG).show();
                //break;
                return true;// Biz burada return yerine return de kullanabilriz

                Aşağıda OnClick metodu ile aynı şeyi yapacağımız için burayı yorum satı
                rı haline getiridk

                .*/

            case(R.id.action_save):
                Toast.makeText(context,"Kaydet Tıklandı",Toast.LENGTH_LONG).show();
                //break;
                return true;// Biz burada return yerine return de kullanabilriz.

            case(R.id.action_quit):
                Toast.makeText(context,"Çıkış Tıklandı",Toast.LENGTH_LONG).show();
               // break;
                return true;// Biz burada return yerine return de kullanabilriz.

        }

        return super.onOptionsItemSelected(item);
    }

    public void mnu_click(MenuItem item){//Tıklanan ayarlar menüsü
        //Parantez içi hangi dönüş şekli ise o girildi
        switch (item.getItemId()){
            case(R.id.action_settings):
                Toast.makeText(context,"Ayarlar Tıklandı",Toast.LENGTH_LONG).show();
                break;
            case(R.id.action_save):
                Toast.makeText(context,"Kaydet Tıklandı",Toast.LENGTH_LONG).show();
                break;
            case(R.id.action_quit):
                Toast.makeText(context,"Çıkış Tıklandı",Toast.LENGTH_LONG).show();
                break;
            //Burada yularıda case içinde yaptığımız şeyi metod olarak yaptık kısaca
            //aslında aynı işi yapıyor


        }




    }



}
