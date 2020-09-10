package com.example.a4ders;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtview;
    private Button button;
    private LinearLayout linear;
    private int i ;
    private LinearLayout.LayoutParams txtLP,buttonLP;
    private ScrollView scroll;


     private  void init(){

         linear=new LinearLayout(this);
         linear.setOrientation(LinearLayout.VERTICAL);
         scroll=new ScrollView(this);

         for(i=1;i<=5;i++){
             txtview=new TextView(this);
             txtview.setText(i+".textview");
             txtLP=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
             txtLP.setMargins(0,100,0,100);
             txtLP.gravity= Gravity.CENTER;
             txtview.setTextColor(Color.MAGENTA);
             txtview.setTextSize(20);
             txtview.setLayoutParams(txtLP);
             linear.addView(txtview);



             button=new Button(this);
             buttonLP=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
             buttonLP.gravity=Gravity.LEFT;
             button.setLayoutParams(buttonLP);
             button.setText(i+".buton");
             button.setTextSize(20);
             button.setTextColor(Color.YELLOW);
             linear.addView(button);

         }

         scroll.addView(linear);



         setContentView(scroll);





     }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       init();

    }
}
