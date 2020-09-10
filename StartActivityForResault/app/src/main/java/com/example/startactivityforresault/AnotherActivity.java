package com.example.startactivityforresault;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {
    TextView txtSONUC;
    Button sONUCyollaYOLLA;
    int toplam;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtyanother);
        txtSONUC = findViewById(R.id.txtSonucID);
        sONUCyollaYOLLA = findViewById(R.id.BUTONSONUCyolla);

        sONUCyollaYOLLA.setOnClickListener(new View.OnClickListener() { // 9 değerini şimdi ana altiviteye yollayacaz
            @Override
            public void onClick(View v) {
                Intent returnIntent=new Intent(); // intetnt olusturduk
                returnIntent.putExtra("toplam",toplam);//Burada putExtra ile veriyiy yolladık
                setResult(RESULT_OK,returnIntent);//setResault ile yolluyoruz ve bazi sabitlerle yolluyoruz.Resault OK İLE yolluyoruz burada.
                finish();// işi bitiridk


            }
        });









        Intent intent = getIntent();
        int x = Integer.parseInt(intent.getStringExtra("x"));  // x ve y değerlerini aldık
        int y = Integer.parseInt(intent.getStringExtra("y"));
        toplam = x + y;
        txtSONUC.setText(x+ "+"+y+" = "+toplam);


    }
}