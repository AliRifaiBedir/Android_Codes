package com.example.androidspinnerlelistehalindemzikalmak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    /*Spinnerdan seçilen dosyasnı çalacak
     3 tane müzik var.A

     Ayrıca Checkbox vara ona tıklayınca start dedikten
     sonra şarkı tekrar tekrar çalacak

     Şarkılarımızı values içiçnde String içinde
     StringArray ile tanımladık ve onlara ulaşmak üiçin müzik
     adında dizi olustrurk

     */

    String müzikler[];//
    CheckBox chkLoop;
    Spinner cboMüzikler;
    ToggleButton btnStart_Stop;
    Context context = this;
    int secilenMuzik;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Dizinn içindeki elamnları spinnerda göstermek için arrayadaptor kullanmak lazım

        ArrayAdapter<String> adp = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, müzikler);
        //(cONTEXT,Yerleşim elemanlarının liste biçiimi,hangi eleman gösterilecek)
        cboMüzikler.setAdapter(adp);//Bunun saysinde spinner içinde elemanlar görülecek
        cboMüzikler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Elemanlarda birine tıklanıdığında ne yapacam
               String secilen= (String) parent.getItemAtPosition(position);
               //sağ taraf obje türünden değer dönüyor o yzuden cast ile stringe çeviridk
                //Burada pozisyonuyla sırası gelen elemanı olustrudk

                switch (secilen){
                    case "hzn":
                        secilenMuzik=R.raw.hzn;
                        break;
                    case "sago":
                        secilenMuzik=R.raw.sago;
                        break;
                    case "yol":
                        secilenMuzik=R.raw.yol;
                        break;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    public  void btnStartStop(View v){
        if (btnStart_Stop.isChecked()){
            mediaPlayer=MediaPlayer.create(context,secilenMuzik);
            //(context,nerede olduğu)
            mediaPlayer.start();
            if (chkLoop.isChecked()){
                mediaPlayer.setLooping(true);
            }

            //Müzk bittiğinde ne yapılması gereken işlemler
            //Amacmız butona bastıktan sonra tekrardan toogle da start kısmı gelmesi
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    btnStart_Stop.setChecked(false);

                }
            });




        }else {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();

            }

        }





    }

    public void init() {
        cboMüzikler = findViewById(R.id.cboMüzikler);
        chkLoop = findViewById(R.id.chkLoop);
        btnStart_Stop = findViewById(R.id.btnStartStop);
        müzikler = context.getResources().getStringArray(R.array.muzikler);
        //Bunun sayesinde stringarray içindeki müzikelre ulasıyoruz


    }


}
