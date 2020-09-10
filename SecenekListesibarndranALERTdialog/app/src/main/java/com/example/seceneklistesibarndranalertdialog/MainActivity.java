package com.example.seceneklistesibarndranalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    String s="Seçtikleriniz : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList array=new ArrayList<>();//Array list olusturudk
        final CharSequence items[] = {"Windows", "Pardus", "Macosx", "Linux"};//Dizi Olusturudk
        boolean checkedItems[] = {true, false, false, true};//Boolen olduğu için tırnaksız yazdık

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);//AlerTDialog kurudk
        alertDialog.setTitle("İşketim Sistemi Tecihiniz");
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //Her checkbox işaretledindiğnde ya da seçim kaldırılıdığında tetiklenir
                /*
                dialog:pencere
                which:secilen ya da silinen elamanın indeksi
                isChecked:Elemaının seçilip seçilmediği
                 */
                if (isChecked){
                    array.add(items[which].toString());//Her eklediğimizi ekranda gösterecek

                    Toast.makeText(context,items[which],Toast.LENGTH_LONG).show();
                    //Toast mesajı ile ekleneni gösterdik

                }else{
                    array.remove(items[which].toString());//Secili obje dizinin içinde varsa kaldırıcak
                    Toast.makeText(context,items[which]+" kaldırıldı",Toast.LENGTH_LONG).show();
                }

            }
        });

        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Tamama basınca tetiklenir
                Toast.makeText(context,"Sectiklrtiniz \n"+array,Toast.LENGTH_LONG).show();


            }
        }).show();





    }
}


