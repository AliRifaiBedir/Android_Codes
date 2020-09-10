package com.example.a28derstoogle;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class swithchechkboxörnek extends AppCompatActivity {
    EditText edtAD,edtSOYAD;
    RadioGroup radioGroup;
    RadioButton radioevli,radiobekar;
    Switch switch1;
    CheckBox checkspor,checksinema,checkdans,checkmüzik;
    Button buttonYazdır;
    TextView textViewSonuc;
    GridLayout gridLayout;
    Context context=this;
    StringBuffer stringBuffer;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switccheckboxornek);
        init();


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // burada biz grid layout içindeki checkboxların
                                                                                         //görünüp görünmeyeceğini ayarladık
                if (isChecked){
                    gridLayout.setVisibility(View.VISIBLE);
                }
                else{
                    gridLayout.setVisibility(View.GONE);
                    replacechecked(gridLayout);
                    textViewSonuc.setText("");
                    stringBuffer.delete(0,stringBuffer.length());
                }
            }
        });



        buttonYazdır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSonuc.setText("");
                stringBuffer.delete(0,stringBuffer.length());

                if (edtAD.getText().toString().isEmpty()&&edtAD.getText().toString().equals("")){
                    Toast.makeText(context,"lütfen isim giriniz",Toast.LENGTH_LONG ).show();
                    return;
                }

                else {
                    stringBuffer.append("isminiz:"+edtAD.getText());
                    edtAD.setText("");
                    edtAD.requestFocus();

                }
                if (edtSOYAD.getText().toString().isEmpty()&&edtSOYAD.getText().toString().equals("")){
                    Toast.makeText(context,"lütfen Soyisim giriniz",Toast.LENGTH_LONG ).show();
                    return;
                }
                else {
                    stringBuffer.append("\nSoyisminiz:"+edtSOYAD.getText());
                    edtSOYAD.setText("");

                }

              /*  int radio=radioGroup.getCheckedRadioButtonId();
                switch (radio){
                    case R.id.RadioEvli:
                        stringBuffer.append("\nMedeni Durumu : Evli  ");
                        break;
                    case R.id.RadioBekar:
                        stringBuffer.append("\nMedeni Durumu : Bekar  ");

                }*/


              if (radiobekar.isChecked()){
                  stringBuffer.append("\nMedeni Durumu :  "+radiobekar.getText());
              }
              else if (radioevli.isChecked())  {
                      stringBuffer.append("\nMedeni Durumu :   "+radioevli.getText());

                  }






                String hobi="";

                if (checkdans.isChecked()){
                    hobi+="dans ";
                    ;

                }

                if (checkmüzik.isChecked()){
                    hobi+="müzik ";
                    ;}
                if (checksinema.isChecked()){
                    hobi+="sinema ";
                   }
                if (checkspor.isChecked()){
                    hobi+="spor ";
                    }

                if (hobi.isEmpty()&&hobi.equals("")){
                    stringBuffer.append("\n hobi yok");
                }

                stringBuffer.append("\nhobileriniz: "+hobi);



                textViewSonuc.setText(stringBuffer.toString());







            }
        });
      /*

      Bu ksıım xml tarafında yaptığımımz karakter sınırlaması için programatik tarafı

        edtAD.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals("")){ //for back space
                    return source;
                }
                if (source.toString().matches("[a-zA-Z ]+")){
                    return source;


                }
                return " "; // bişey yazmasın demek
            }
        }});


        edtSOYAD.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals("")){ //for back space
                    return source;
                }
                if (source.toString().matches("[a-zA-Z ]+")){
                    return source;


                }
                return " "; // bişey yazmasın demek
            }
        }});

*/


    }

    public  void init(){
        edtAD=(EditText) findViewById(R.id.EdittextID);
        edtSOYAD=(EditText) findViewById(R.id.EdittextID2);
        radioGroup=(RadioGroup) findViewById(R.id.RadioGroupmedeni);
        radioevli=(RadioButton) findViewById(R.id.RadioEvli);
        radiobekar=(RadioButton) findViewById(R.id.RadioBekar);
        switch1=(Switch) findViewById(R.id.SwitchID2);
        checkdans=(CheckBox) findViewById(R.id.checkboxDANS);
        checkmüzik=(CheckBox) findViewById(R.id.checkboxMUZİK);
        checksinema=(CheckBox) findViewById(R.id.checkboxSİNEMA);
        checkspor=(CheckBox) findViewById(R.id.checkboxSPOR);
        gridLayout=(GridLayout) findViewById(R.id.GridlayoutID);
        textViewSonuc=(TextView) findViewById(R.id.textviewIDLAST);
        buttonYazdır=(Button) findViewById(R.id.yazdırBUTONID);
        stringBuffer=new StringBuffer();






    }
    public void replacechecked(ViewGroup viewGroup){
        View child;


        for (int i =0;i<viewGroup.getChildCount(); i++){ // Burada view group içinde dolaşacak tek tek dolacaşak eğer
            child=viewGroup.getChildAt(i);
            if (child instanceof ViewGroup){
                replacechecked((ViewGroup) child); //gelen eleman view groupsa metod bişey yapmayacak

            }
            else if(child instanceof CheckBox){
                ((CheckBox) child).setChecked(false);    //ama eğer checkbox ise
                                                        //içini temizleyecek.
            }



        }




    }















}
