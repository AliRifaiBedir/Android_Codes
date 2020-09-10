package com.example.stilolusturma;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.Gravity.CENTER;

public class Toplamaİslemi  extends AppCompatActivity {
    Button buton;
    TextView text1,text2,toplam;
    EditText edt1,edt2;
    int s1,s2,sonuc;
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   setContentView(R.layout.toplamaislemi);
   edt1=(EditText) findViewById(R.id.edt1);
   edt2=(EditText) findViewById(R.id.edt2);
   text1=(TextView) findViewById(R.id.txt1);
   text2=(TextView) findViewById(R.id.txt2);
   toplam=(TextView) findViewById(R.id.sonuc);
   buton=(Button) findViewById(R.id.btn1);

   buton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           s1=Integer.parseInt(edt1.getText().toString());
           s2=Integer.parseInt(edt2.getText().toString());
           sonuc=s1+s2;
           toplam.setText("toplam"+sonuc);

        //  Toast.makeText(Toplamaİslemi.this, "huhuhuhuhuhu", Toast.LENGTH_SHORT).show();
        //custom.xml ULASALIM SİMDİ

           LayoutInflater li=LayoutInflater.from(context);
            View layout = li.inflate(R.layout.customtoast, null);
            //simdi imageview ulasalım

           ImageView image=(ImageView)layout.findViewById(R.id.imageID);
           image.setImageResource(R.mipmap.ic_launcher);


           //simdi textview ulasalım

           TextView text=(TextView)layout.findViewById(R.id.txtID);
           text.setText("sonuc"+sonuc);

           Toast tost=new Toast(context);
           tost.setGravity(CENTER,0,0);
           tost.setDuration(Toast.LENGTH_LONG);
           tost.setView(layout);
           tost.show();



       }
   });











    }
}
