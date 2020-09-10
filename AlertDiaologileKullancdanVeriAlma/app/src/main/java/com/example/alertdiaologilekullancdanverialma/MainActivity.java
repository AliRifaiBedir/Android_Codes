package com.example.alertdiaologilekullancdanverialma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGöster;
    TextView txtDeğerGöser;
    Context context=this;

 // Burada kendimiz dialog penceresini biz ayarladık.
    //Dialog pecnecresini biz ayarlar xml de ayarladık
    // ve o mesajı kullanıdk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGöster=findViewById(R.id.btnGöster);
        txtDeğerGöser= findViewById(R.id.txtDeğerGöster);
        btnGöster.setOnClickListener(new View.OnClickListener() { // Ayarlar xml ulasmak için bu metodu kullanırız
            @Override
            public void onClick(View v) {
                LayoutInflater li =LayoutInflater.from(context);
                View ayarView =li.inflate(R.layout.ayarlar,null     );
                //Burada dönen değer bir view olduğu için ayarview adlı değişken olusturudk
                final EditText editTextGiris= ayarView.findViewById(R.id.editTextGiris);
                TextView txtsonuc=ayarView.findViewById(R.id.txtsonuc);
                // Burada edt ve txt bu şekilde ulaştık.
                txtsonuc.setText("Dialog Göster");
                txtsonuc.setTextSize(25);

                AlertDialog.Builder alertDialog= new AlertDialog.Builder(context);
                alertDialog.setView(ayarView);// HANGİ VİEW GÖSTERSİN
                alertDialog.setMessage("Çıkmak için evete basınız");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //EDT yazdığımızm değeri text gösterecez
                        txtDeğerGöser.setText(editTextGiris.getText().toString());

                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss(); //Dialog kapansın


                    }
                }).show();





            }
        });



    }
}
