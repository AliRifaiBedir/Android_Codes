package com.example.androidalertkullanm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    /* AlerDialog kullanıcların kararlarırnn alındığı ya da
    bilgilerinin alındığı pencerelddir.

    Bunun sayesinde kullanıclar programın nasıl kullanıldığını öğrenebilir

    Biz burada alertDialogbuilder kullanacaz


     */


    Context context=this;
    Button btnGöster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGöster=findViewById(R.id.BtnGöster);
        btnGöster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
                alertDialog.setTitle("Alert Dialog Penceresi");
                alertDialog.setMessage("Çıkmak için Evete Basınız");
                alertDialog.setCancelable(true); // Bunun ile ekranın dışına bastığımızda kapansın mı alert dialog mk soruyroz.
                alertDialog.setIcon(R.mipmap.ic_launcher_round);
                alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {//Dialog kutusunda buton ismi :evet
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // uygulamayı kapatır

                        //Evete tıklayınca yapılması gerekenler


                    }
                })
                        .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {//Dialog kutusunda buton ismi :hayır
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss(); // Dialog penceresini kapatır

                                //Hayıra tıklayınca yapılması gerekenler

                            }
                        }).show();



            }
        });


    }
}
