package com.example.startactivityforresault;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etX,etY;
    TextView txtSonuc;
    Button değeryolla;
    Context context=this;
    static final int Contact_Request=1; // sabit değer olustrrudk genelde böyle kullanılıyor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etX=findViewById(R.id.etX);
        etY=findViewById(R.id.ety);
        txtSonuc=findViewById(R.id.txtSonucID);
        değeryolla=findViewById(R.id.değeryollaID);

        değeryolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,AnotherActivity.class);
                intent.putExtra("x",etX.getText().toString());
                intent.putExtra("y",etY.getText().toString());
                startActivityForResult(intent,Contact_Request); // burada verimizi gönderdik
            }
        });




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // bu metodu kullanrak diğer aktiviiden gelen veriyi yakalayacaz
        if (requestCode==Contact_Request){ // EĞER REQUEST KOD BENİM KODUMSA
            if (resultCode==RESULT_OK){ // İKİNCİ ACTİTYDE Kİ RESULTCODE RESAULT OK İSE
             txtSonuc.setText(String.valueOf(data.getIntExtra("toplam",-1)));


                                        // DEĞERİ ALABİLİLRZ
            }else if (resultCode==RESULT_CANCELED){
                Toast.makeText(context,"beklenmedik şekilde sonlandı",Toast.LENGTH_LONG).show();
            }

        }




        super.onActivityResult(requestCode, resultCode, data);





    }
}
