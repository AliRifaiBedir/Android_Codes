package com.example.a28derstoogle;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class switchkontrol extends AppCompatActivity {
    Switch aSwitch;

    Button button;
    TextView textView;
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switchkontrolu);
        aSwitch=(Switch) findViewById(R.id.switcID);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// bunun sayesinde versiyonlarda çaloşcak
            aSwitch.setShowText(true);
        }
        button=(Button) findViewById(R.id.buttonID);
        textView=(TextView) findViewById(R.id.textID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()==true){
                    Toast.makeText(context,"ali rifai bedir",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(context,"ronaldinho",Toast.LENGTH_LONG).show();

                }


            }
        });



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aSwitch.isChecked()==true){
                    textView.setText(aSwitch.getTextOn());


                }
                else {
                    textView.setText(aSwitch.getTextOff());
                    aSwitch.setEnabled(false);
                }



            }
        });











    }
}
