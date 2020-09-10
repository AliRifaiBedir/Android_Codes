package com.example.dinamikmenolusturmagroupid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
CheckBox checkBox;
Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox=findViewById(R.id.checkbox1);

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

    @SuppressLint("WrongConstant")
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,1,1,"add").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            //Her bir menüye tıkladığımızda yapılack işlemleri menuClick ile bu şekilde
            //yapıyoruz ";" kaldırıp ne yapacagımıza karar veriyoruz
            //Biz burada Toast mesajı yayınladık

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(context,item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });


        try {
            menu.add(0,2,2,"edit").setIntent(Intent.parseUri("http://milliyet.com.tr",1));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Burada ise intent ile başka bir avtivy ya da servise gidecez
        //"MİLLİYET.COM" adresine gitmeyi yapacaz simdi



        menu.add(0,3,3,"delete");
        //Burada group ID ile ekliyoruz
        //(MenuID,Menüdeki Herbir elemanın ID,İtemlerin görüntülenme sırası,görüntüeneck isim

        menu.add(1,4,5,"copy");
        menu.add(1,5,4,"paste");
        menu.add(1,6,6,"exit");

        //Burada ikinci gruba ID olarak 1 verdik peki neden?
        //0 ve 1 AYRI AYRI çalıştırabiliriz
        //Aşağıda onPrepare metodu ile bunu yapacağız

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        /* Her zaman menü gösterilmeden önce çalışır ve içine
        bir şey yazmazsak düz gruba gider işlem yapmaz.
         */
        /*menu.setGroupVisible(1,false);
        Bunu yaparak 1 numaralı grup görünmeyecek
        Aşagıda ise checkBox EKLEYEREK bu işi yaptık eğer
        checkBox işaretliyse 1 numaralı group gösterilsin yoksa gösterilmesin
        yaptık
        */



        menu.setGroupVisible(1,checkBox.isChecked());
       // checkBox işaretliyse 1 numaralı group gösterilsin yoksa gösterilmesin
        return super.onPrepareOptionsMenu(menu);
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
