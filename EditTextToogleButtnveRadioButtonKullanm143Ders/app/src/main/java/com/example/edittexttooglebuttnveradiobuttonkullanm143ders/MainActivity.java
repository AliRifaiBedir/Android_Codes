package com.example.edittexttooglebuttnveradiobuttonkullanm143ders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*Uygulamada toogle buton of olıunca radio grup gizlenecek
    dolayısyla normal ve passwprd görünmeyecek
    İkincisi de Edittext veri yazınca normal konumundaysa
    radio buton yazacak eğer password ise şiftreli
    şekilde yazacak
       */


    EditText editText;
    ToggleButton toggleButton;
    RadioGroup radioGroup;
    RadioButton radioText, radioPassword;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        toggleButton = findViewById(R.id.toggleButton);
        radioGroup = findViewById(R.id.radioGroup);
        radioText = findViewById(R.id.radio1);
        radioPassword = findViewById(R.id.radio2);
        toggleButton.setOnClickListener(this);//İmplemet sonrası gerekli kod

      /*  radioText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Compound secilen buton,b ise secilimi değil mi

                if (isChecked==true){
                    Toast.makeText(context,"Normal Seçildi",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Password Secildi Seçildi",Toast.LENGTH_LONG).show();


                }
            }
        });

        Bunu her zaman kullanmayacaz sadece iki tane radio buton varsa kulanacaz şimdi gidip onClick
        metodu ile yapcaz

        */


    }

    @Override
    public void onClick(View v) {
        if (toggleButton.isChecked()) {
            radioGroup.setVisibility(View.VISIBLE);

        } else {
            //radioGroup.setVisibility(View.INVISIBLE); Eğer bunu yaparsak kayma olmaz
            radioGroup.setVisibility(View.GONE);

        }

    }


    public void radioClicked(View v) {
        Boolean kontrol = ((RadioButton) v).isChecked();
        switch (v.getId()) {


            case R.id.radio1:
                if (kontrol) {
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                break;
            case R.id.radio2:
                if (kontrol) {
                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

                    break;


                }


        }


    }
}
