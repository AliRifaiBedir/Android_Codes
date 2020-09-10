package com.example.androidlistviewkullanm;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    //Bir dizi olusturacaz
    //Değiştirilmezlik için static final dedik
    //Herbir satır tek bir textView barındırır listView bu önemli


   static final String[] meyveler= new String[]{"Elma","Armut","Muz","Şeftali","Böğürtlen","Hindistan Cevizi","Kivi","Mandalina","Portakal","Yeni Dünya",
    "Karpuz","Kavun","Kiraz","Çilek"};
   //Amacımız bunları listView'de göstermek ama düz gösteremeyiz ArrayAdapter kullanacaz


    ListView liste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.lvMeyveler);
        //Aşagıdaki kodu yorum satırı yaptık çünkü daha sonra özellestiripi kendimiz tanımladık 49.satırda
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.text1,meyveler);
        // (context,Elemanın Yerleşim Birimi,İçeride Gösterilecek Textin Birimi,Gösterilecek list)

        //Şimdi R.id.Text1 YERİNE kendimiz tasarım yapacaz ve layout içinde bir xml olusturaaz
        //Root elementi TextView olacak

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.list_meyve,meyveler);

        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Toast.makeText(context,String.valueOf(parent.getItemAtPosition(position)),Toast.LENGTH_LONG).show();
                //Toast mesajı ile de aşagıda alert ile yaptığımız şeyi yapabiliriz




                //(view :secilen hirbir eleman, position:elemanların indexi)
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                dialog.setMessage(meyveler[position]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                   //SetCanceble sayesinde sağa sola tıklayınca tıklama yapılmıyor
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//Yani dialog kapansın




                    }
                }).show();







            }
        });





    }

    //Herbir elemena tıkaldığımızda çıkacak AlertDİALOG çıksın









}
