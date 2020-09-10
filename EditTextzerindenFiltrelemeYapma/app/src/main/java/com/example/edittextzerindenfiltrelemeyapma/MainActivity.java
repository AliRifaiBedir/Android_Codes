package com.example.edittextzerindenfiltrelemeyapma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFilter;
    String beforeTextChanged, onTextChanged, afterTextChanged;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFilter = findViewById(R.id.etFilter);
        etFilter.addTextChangedListener(new TextWatcher() {//Text değişicince olacak olan metod
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Text üzerinde değişiklik olamdan önce
                beforeTextChanged=etFilter.getText().toString();



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TEXT üzerinde değişiklik yapınca  olayalr
                //onTextChanged=etFilter.getText().toString();

                //(s:Burada bizim girdiğimiz edittext,start:başlangıç değeri,Before:önceki text uzunluğu)
                s.toString();//onTextChanged=etFilter.getText().toString(); aynı işi yapıyor



            }

            @Override
            public void afterTextChanged(Editable s) {
                //Text üzerinde değişiklik sonra olaack olaylar
                afterTextChanged=etFilter.getText().toString();
                Toast.makeText(MainActivity.this,"before: "+beforeTextChanged+"\n"+"on :"+onTextChanged+"\n"+
                        "after :"+afterTextChanged,Toast.LENGTH_LONG).show();


            }
        });


    }
}
