package com.example.androidsharedpreferenceskullanm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Fazla buton olduğu için implement metodunu kullandık


    /*SharedPreferces sınıfı olusturacaz kaydet
    kaydettiğin değeri al,sil ve kaldır metodları olusturcaz
    daha sonra programın içndegerekli yerlerde bunları kullanacaz.
    Bundan dolayı şimdi başka bir java.Sınıfı açıyotuz

     Programın Amacı:
     CheckBox işaretliyse edittext yazdığımız string değeri kaydedecez

     */




    CheckBox chk1;
    EditText etIsim;
    Button btnSave,btnDelete,btnRemove,btnGo;
    String text;
    Context context=this;
    sredPrefernc sharedPreferenc; //SharedPrefences sistemine kaydetmek içim
    //ordan bir tane örnekleme alma gerekiyor burda onu yaptık


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnGo.setOnClickListener(this);

    }

    public void init() {
        chk1 = findViewById(R.id.chk1);
        etIsim = findViewById(R.id.etIsim);
        btnDelete = findViewById(R.id.btnDelete);
        btnGo = findViewById(R.id.btnGo);
        btnRemove = findViewById(R.id.btnRemove);
        btnSave = findViewById(R.id.btnSave);
        sharedPreferenc = new sredPrefernc();
        //Burada nesne olusturuyoruz.
        //sredPrefernc ile Ram de yer ayırdık


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                if (chk1.isChecked()){
                   text= etIsim.getText().toString();
                   sharedPreferenc.save(context,text);
                    Toast.makeText(context,"Kaydedildi",Toast.LENGTH_LONG).show();
                }
            break;

            case R.id.btnDelete:
                sharedPreferenc.clear(context);
                Toast.makeText(context,"Silindi",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnRemove:
                sharedPreferenc.remove(context);
                Toast.makeText(context,"Kaldırıldı",Toast.LENGTH_LONG).show();
              break;
            case R.id.btnGo:
                Intent intent=new Intent(context,SecondActivity.class);
                startActivity(intent);









        }




    }
}
