package com.example.intentilebundleilenumarayaaramayapma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumara;
    Button btnYolla;
    Bundle bundle;
    Intent intent;
    Context context=this;

    //Anahtar değer mantığıyla yapacaz ve Bundle ile yapacaz
    //Android manifestte ikinci aktiviteyi tanıtnmayı unutma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumara=findViewById(R.id.edtID);
        btnYolla=findViewById(R.id.ButonID);

        btnYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(context,SecondActivity.class  );// nereden nereye gideceğini söyledik
                bundle=new Bundle(); // bundle olusturduk
                bundle.putString("no",etNumara.getText().toString()); // key value mantığıyla değeri attık
                intent.putExtras(bundle); //bundle yolladık
                startActivity(intent);

            }
        });


    }
}
