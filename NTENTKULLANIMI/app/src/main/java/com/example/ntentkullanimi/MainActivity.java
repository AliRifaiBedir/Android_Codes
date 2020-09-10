package com.example.ntentkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNAME,etPASS;
    Button bntGÖNDER,btnTEMİZLE;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bntGÖNDER.setOnClickListener(this);
        btnTEMİZLE.setOnClickListener(this);
    }


// ikinci aktiviteyi olusturunca manifestte tanıtmayı unutma

   public  void init(){
        etNAME=findViewById(R.id.etNAMEID);
        etPASS=findViewById(R.id.etNpassID);
        bntGÖNDER=findViewById(R.id.BUTONGÖNDER);
        btnTEMİZLE=findViewById(R.id.BUTONTEMİZLE);




   }


    @Override
    public void onClick(View v) { // v tıklanan buton
        switch (v.getId()){
            case R.id.BUTONGÖNDER:
                if (etNAME.getText().toString().equalsIgnoreCase("ali")&&etPASS.getText().toString().equals("1")){
                    // ikinci ekrana geçecez
                    Intent intent= new Intent(context,SecondActivity.class );
                    intent.putExtra("İsim",etNAME.getText().toString());// Burada isim değer veriyoryuz.Ve öylece mesaj gönderme
                     intent.putExtra("sifre",etPASS.getText().toString());                                                          // islemi yapıyoruz.İsim değer ilişkisi önemli

                    startActivity(intent);//expilicit intent denir.Yani gideceği yer belli

                }
                else{
                    Toast.makeText(context,"kullanıcı adı veya sifre hatalı",Toast.LENGTH_LONG).show();

                }

            break;
            case R.id.BUTONTEMİZLE:
                etNAME.setText("");
                etPASS.setText("");
                etNAME.requestFocus();
                break;


        }


    }
}