package com.example.clipboardmanager_sistemservisleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*Kes kopyala yapıştır için by sistem servisini kullanıyoruz
    resim,yazı,video içiçn bu sınıfı kullanıyorruz.
    Bunlar da sistem servisidir.
     *

    /*Burada copy Text tarafına girilen
    string değer daha sonra buton yardımıyla kopyalanıyor
    daha sonra da paste düpmesine basınca ikinci
    edittext ksımına yapıstıyrıyor.

     */


    EditText etCopy,etPaste;
    Button btnCopy,btnPaste;
    Context context=this;
    ClipboardManager myClipBoard;
    ClipData myClip;//Kopyalama ve yapıştırma için
    //bu sınıfı kullanıyoruz  ve kopyalanac verinin
    //tipini belirtiyoruz.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCopy=findViewById(R.id.etCopy);
        etPaste=findViewById(R.id.etPaste);
        btnCopy=findViewById(R.id.btnCopy);
        btnPaste=findViewById(R.id.btnPaste);
        myClipBoard=(ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        //Sistem servisi olduğu için bunu yapıyotuz
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=etCopy.getText().toString();
                myClip=ClipData.newPlainText("etiket",text);
                //(Etiket,kopyalanacak veri)
                //Kopyalanacak verinin türünü belirttik burada

                myClipBoard.setPrimaryClip(myClip);
                //Kopyalama islemi gerçekleşti bununla
                Toast.makeText(context,"Kopyalama işlemi tamamlandı",Toast.LENGTH_LONG).show();






            }
        });

        btnPaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myClipBoard.hasPrimaryClip()){
                    myClip=myClipBoard.getPrimaryClip();
                  ClipData.Item ıtem=  myClip.getItemAt(0);
                  //Bununla panoyakopyalanan ilk veriiy alıyoruz
                    // Burada dönen değer Item olduğu için bu değişkeni yaptık.
                    etPaste.setText(ıtem.getText().toString());
                    Toast.makeText(context,"Yapıstırma İslemi Tamamlandı",Toast.LENGTH_LONG).show();
                }



            }
        });



    }
}
