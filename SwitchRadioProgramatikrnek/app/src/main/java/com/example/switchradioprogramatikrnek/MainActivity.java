package com.example.switchradioprogramatikrnek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowAnimationFrameStats;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    LinearLayout linearTaksitSayısı,linearTaksitler;
    RadioGroup radioGroup;
    RadioButton radioButtonTaksit,RadioButtonTekcekim;
    Button buton;
    String giris;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();






       /* // Ekranın yatay ve dikey görünmleri için
        //Çok tercih edilen yöntem değil

        WindowManager wm= (WindowManager) getSystemService(WINDOW_SERVICE);//ÖRNEKLEME ALDIK WM ADINDA
        Display dsp= wm.getDefaultDisplay();//Display tarafından bir değer döndürür bu getDefault
        if (dsp.getHeight()>dsp.getWidth()){//fonktsiyon ve metodalrı kullanıdk
            setContentView(R.layout.activity_main);

        } else if (dsp.getHeight()<dsp.getWidth()){
            setContentView(R.layout.activity_main_landscape);


        }*/



        RadioButtonTekcekim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (RadioButtonTekcekim.isChecked()){
                    linearTaksitler.setVisibility(View.INVISIBLE);
                    linearTaksitSayısı.setVisibility(View.INVISIBLE);
                    linearTaksitSayısı.removeAllViews();// bütün viewları siler

                    editText.setText("");
                }
                else if (radioButtonTaksit.isChecked()){
                    linearTaksitler.setVisibility(View.VISIBLE);
                    editText.setText("");
                }
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_DEL){
                    linearTaksitSayısı.removeAllViews();
                }

                return false;
            }
        });



      /*  int secilenradio=radioGroup.getCheckedRadioButtonId();
        switch (secilenradio){
            case R.id.tekcekimID:
                linearTaksitSayısı.setVisibility(View.INVISIBLE);
                break;

            case R.id.taksitlicekimID:
                linearTaksitSayısı.setVisibility(View.VISIBLE);
                break;
        }
        */


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giris=editText.getText().toString();
                if(giris.matches("")){
                    Toast.makeText(context,"lütfen sayısal bir değer giriniz",Toast.LENGTH_LONG).show();
                    return;
                }
                linearTaksitSayısı.setVisibility(View.VISIBLE);
                linearTaksitSayısı.removeAllViews();

                int taksitsayısı=Integer.parseInt(editText.getText().toString());


                if(taksitsayısı>0){
                    for(int i=1;i<=taksitsayısı;i++){
                        CheckBox  chk= new CheckBox(context);
                        chk.setText(i +". TAKSİT");
                        linearTaksitSayısı.addView(chk);

                        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked){
                                    Toast.makeText(context,buttonView.getText(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                        // check boxlar için event yakalama

                    }


                    //checkbox olustur

                }



            }
        });












    }
    public  void init(){
        editText=(EditText) findViewById(R.id.edtID);
        linearTaksitler=(LinearLayout) findViewById(R.id.layoutID);
        linearTaksitSayısı=(LinearLayout) findViewById(R.id.linearpaneltaksit);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroupID);
        radioButtonTaksit=(RadioButton) findViewById(R.id.taksitlicekimID);
        RadioButtonTekcekim=(RadioButton) findViewById(R.id.tekcekimID);
        buton=(Button) findViewById(R.id.butonID);

    }









}
