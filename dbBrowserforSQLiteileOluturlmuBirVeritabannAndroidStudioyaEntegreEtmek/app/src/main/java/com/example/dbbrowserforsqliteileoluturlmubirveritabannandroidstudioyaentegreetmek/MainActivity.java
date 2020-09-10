package com.example.dbbrowserforsqliteileoluturlmubirveritabannandroidstudioyaentegreetmek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    /*Burada yaptığımız şey dbSQL de tablo olusturuk daha
    sonra burada assets klasör olusurup veritabanını bu klasöre attık

     */


    EditText enEditText, trEditText;
    Button btnCevir;
    DatabaseHelper dbHelper;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enEditText = findViewById(R.id.enEditText);
        trEditText = findViewById(R.id.trEditText);
        btnCevir = findViewById(R.id.btnCevir);

        dbHelper = new DatabaseHelper(context);
        //Şİmdi dbHelperın bütün metodlarını kullanabilrim
        try {
            dbHelper.createDatabase();
            dbHelper.openDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        btnCevir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String turkceKelime = trEditText.getText().toString();
                Cursor crs = dbHelper.getSqLiteDatabase().query("kelimeler", new String[]{"kelimeEn"}, "kelimeTr = ?",
                        new String[]{turkceKelime}, null, null, null);
                if (crs.getCount() > 0) {
                    crs.moveToFirst();
                    String ingilizceKelime = crs.getString(crs.getColumnIndex("kelimeEn"));
                    enEditText.setText(ingilizceKelime);
                } else {
                    Toast.makeText(context, "Kelimenin Başlığı Bukunmadı", Toast.LENGTH_LONG).show();
                    trEditText.getText().clear();

                }


            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.close();
    }
}
