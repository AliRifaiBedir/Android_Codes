package com.example.androidwebviewkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    /*Androide online ya da offline olarak vebsayfalarını göstermek
    için kullanılan kontrol vebwiew ile baya bir uygulama var
     */

    //SetContentView kısmını kaldır
    // <uses-permission android:name="android.permission.INTERNET"/> bu izni vermek lazım manifestte
    //Ayrıca daha güzel görünün içiçn toolbarı kaldırmank yani thema değiştirmek gerekiyor

    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv=new WebView(context);

        WebSettings ws=wv.getSettings();

        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        //Burada bazı yerleşik özellikerli tanımlıyoruz

       // wv.loadData();//Kendi yağtığımız websitesi için
        wv.loadUrl("https://www.nefisyemektarifleri.com/");//Herhangi bir sayfayı görüntülemek içiçn
        setContentView(wv);




    }
}
