package com.example.listviewzerinecontextmenuyerlestirme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Şimdiki öreneğimizde listView ile  elemanları listeledekten sonra
    elemnladan her habgi birine geldiğimizde context menu olusturcaz
     */
    /*
    Ayrıca listview de her bir satırıda değistirmek isitiyoruz ve yeni bir layout olsuturacaz
     */


    TextView durum;
    ListView list;
    Context context = this;

    static final int ID_SİL = Menu.FIRST;//Bu ve aşağıdaki aslındasabit sayı değişik olsun diye yaptık
    static final int ID_DUZENLE = Menu.FIRST + 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        durum = findViewById(R.id.durum);
        list = findViewById(R.id.list);


        String[] isimler = getResources().getStringArray(R.array.names);
        //İsimler adında string olustrduk ve değerleri string xml den çektik

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.list_item, isimler);
        list.setAdapter(adapter);
        //İsimleri listtVİEW de böylece gösterdil
        //(context,olusturudğumuz list_item,gösterilecek string matrisi)


        //Şimid bundan sonra herhangi bir isme tıkaldığızımda context menu cıkacak
        //onda da iki şey çıkacak sil ve düzenle adında


        registerForContextMenu(list);//Burda benim listView context menu sahibi diiyoruz
        //Daha sonra OnCREATE metodu dışına çıkıyoruz

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, ID_SİL, 0, "Sil");
        menu.add(Menu.NONE, ID_DUZENLE, 1, "Düzenle");
        //(Menu  adı yani ID ,ID,Sıralaması,NE YAZILACAK)

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //Biz şimdi isimlere tıladığımızda ordaki değeri almamız lazım o yuzden aşağıda get.MenuInfo kullanacaz
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //Burada böyle bir şey yaptık çünkü itemGetMENUInfo dönen değeri bir contextMenu info


        TextView seciliEleman = (TextView) info.targetView;

        //İnfo.TargetView ile yani tıkalanan değere ulasmak için TextVİEW değişkeni olustrduk
        //targetView dönen değeri bir View olduğu içiçn
        //Bizim orda tıklşadığımız eleman secili eleman oluyor yani


        if (item.getItemId() == ID_SİL) {
            durum.setText(seciliEleman.getText()+"için sil tıklandı");

            return true;


        }

        if (item.getItemId() == ID_DUZENLE) {
            durum.setText(seciliEleman.getText()+"için düzenle tıklandı");


            return true;


        }


        return false;
    }
}
