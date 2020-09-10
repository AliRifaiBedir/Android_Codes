package com.example.androidsestanmlama;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /* Androidle ile sesli komutlarla yönetmek mümkündür
    Biz burada butona basınca söyledğimiz şeyleri list
    yardımıyla dialog ekranı ile gösterecek ve ordan her hangi birini seçtiğimizde
    en aşağıda olan textview de göstertecez
     */

    /* <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET"/>

    Bu iziznleri vermeyi unutma


    */

    Button btnBasla;
    TextView txtKonusma;
    Context context=this;
    static  int REQUEST_CODE=100;//sABİT DEĞER
    Dialog eslesenText;
    ListView textListesi;
    ArrayList<String> eslesenTextListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBasla=findViewById(R.id.btnBasla);
        txtKonusma=findViewById(R.id.txtKonusma);


        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Öncelikle burda internet bağlantısı kontrol etmemiz lazım
                if (baglıMi())
                {
                    //Ses tanımlama işlemlerini burda yapcaz eğer internet varsa
                    //Bu sınıfta intent yardımıyla kullanılıyor
                    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    //iNTENT SAYESİNDE SES TANUIMLAMA İŞLEMİ BAŞLADI BÖYLECE

                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    //Otomatik olarak dili tanımlasın diyoruz(Dil modeli,buna atanacak değer)

                    startActivityForResult(intent,REQUEST_CODE);
                    //Çünkü işlem sonucu bize geri dönecek o yuzden for resault ile yaptık




                }else {
                    Toast.makeText(context,"Lütfen İnternet Bağlantınızı Yapın" ,Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            //iŞLEM BAŞARILI Bİ ŞEKİLDE GERÇEKLEŞTİYSE DİALOG PENCERESİ AÇILSIN DİYORUZ
            eslesenText=new Dialog(context);
            //Dialog Penceresi açıldı

            eslesenText.setContentView(R.layout.eslesen_sesler_listesi);
            //Dialog olarak karşımıza ne çıkacak

            eslesenText.setTitle("Eşleşen Metni Seçiniz");

            textListesi=eslesenText.findViewById(R.id.liste);
            //Dialog penceresinin içinde gösterilsin diyoruz burada arka planda değil

            eslesenTextListe=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            //EXTRARESULT İLE GELEN DEĞERLERİ DOLDURDUK ARRAYLİST İÇİNE

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,eslesenTextListe);
            textListesi.setAdapter(adapter);


            //Burda da listeden seçilen metni em aşağıdaki textView yazmak için yapacağız
            textListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    txtKonusma.setText("Söylediğiniz "+eslesenTextListe.get(position));

                }
            });



            eslesenText.show();



        }


        super.onActivityResult(requestCode, resultCode, data);
    }





    //İnternet bağlantısını kontrol etme kodumuz burada aşağıda her yerde kullanılabilir
    public  boolean baglıMi(){
        ConnectivityManager con= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //Sistem servisi bu zaten ve sabitlri kullanıyoruz VİBRATİON GİBİ
        NetworkInfo net=  con.getActiveNetworkInfo();
        if ((net !=null) && (net.isAvailable())&& (net.isConnected())){
            return true;

        }else {
            return false;
        }

    }
}
