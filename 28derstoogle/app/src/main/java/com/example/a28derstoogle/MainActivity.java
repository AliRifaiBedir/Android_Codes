package com.example.a28derstoogle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    Button button;
    Context context=this;
    StringBuffer sonuc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=(ToggleButton) findViewById(R.id.toggle);
        button=(Button) findViewById(R.id.button);




        // burada da yaptığımız aynı şey ama burada v öreniğnini toogle olduğunun bildirmemiz gerekli

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean durum = ((ToggleButton)v) .isChecked();
              if( durum==true){

                  Toast.makeText(context,toggleButton.getText(),Toast.LENGTH_LONG).show();
               }
              else{

                  Toast.makeText(context,"nuhuhuuhu",Toast.LENGTH_LONG).show();
              }



            }
        });










        //burada toogle butona tıklayıp içeriğine göre toast mesajı yayınladık
         /*toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (toggleButton.isChecked()==true){
                    sonuc =new StringBuffer();
                    sonuc.append("ali ").append("rifai").append("bedir");
                    Toast.makeText(context, sonuc.toString(),Toast.LENGTH_LONG).show();

                }
                else{



                    Toast.makeText(context, "olmadı",Toast.LENGTH_LONG).show();

                }
            }
        });

           */












        // Butona tıkladığımda toogle drurmuna göre toast mesajı yazırıdk
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()==true){
                    Toast.makeText(context,"toogle aktif",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(context,"toogle aktif DEGİL",Toast.LENGTH_LONG).show();
                }
            }
        });*/



    }
}
