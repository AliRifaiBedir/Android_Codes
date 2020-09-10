package com.example.androidwebviewofflinekullanm_res_raw_sayfahtmlisimlidosyadanokunanhtmlkodu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Context context=this;

    /*Şimdi burda res klasörüne sağ tıkalayıp directory
    den raw adlı klasör ekliyroz daha sonra showinExpolerer ile
    içine dosya adlı html dosyasını atıyoruz

     */

    //res/raw/dosya.html burdan okuma yapacaz burada

     // <uses-permission android:name="android.permission.INTERNET"/>
     //  Bu izni vermeyi unutma manifesste



    //Burada son olarak client metodunu uyguladık bununla diğerlerinin
    //farkı bunu yapınca gideceğimizm sayfa ekrana düz olarak hemen geliyor
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv=new WebView(context);

        WebSettings ws=wv.getSettings();

        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);

        wv.setWebViewClient(new Client());
        //En son olarak bunu yaptık

        //raw içine erişmek için bu kod lazım
        Resources res=getResources();
        try {
            InputStream stream=res.openRawResource(R.raw.dosya);
            InputStreamReader isr=new InputStreamReader(stream);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            String data="";
            String mime="text/html";
            String encoding="utf-8";
            while (true){//Sonsuz döngü
                line = br.readLine();//Verileri satır satır line attık
                if (line!=null){
                    data+=line;//Line da eğer veri varsa += ile dataya ekledik

                }else{
                    //veri yoksa döngüden çık

                    break;
                }


            }
            //En son hangisini açtıysak sırasıyla kapattık
            br.close();
            isr.close();
            stream.close();
            wv.loadData(data,mime,encoding);
            setContentView(wv);


        }catch (IOException e){
            e.printStackTrace();
        }





    }


    //linklere tıkladığımızda androididn kendş tarayıcısında açılıyor
    //Böyle olmaması için onCreate dışına bir metod yazacaz


    public class Client extends WebViewClient{
        //Override edelim


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }




}
