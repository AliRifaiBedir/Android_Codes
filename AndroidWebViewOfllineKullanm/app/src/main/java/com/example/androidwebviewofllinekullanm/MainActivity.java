package com.example.androidwebviewofllinekullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    Context context=this;

    /*Başlangıcta notepad de bir l-html site kodu yazacağız

        <uses-permission android:name="android.permission.INTERNET"/>
        Bu izni vermeyi unutma manifesste



     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv=new WebView(context);

        WebSettings ws=wv.getSettings();

        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        //Burada bazı yerleşik özellikerli tanımlıyoruz

        String data="<html>\n" +
                "       \n" +
                "    <body>\n" +
                "\t\n" +
                "\t<a href=\"https://www.nefisyemektarifleri.com/\" target = \"_blank\">Nefis Yemek Tarifleri</a>\n" +
                "\t<body>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</html>";

        String mime="text/html";
        String encoding="utf-8";

        wv.loadData(data,mime,encoding);
        //Offline kullanmak için bunu yapıtk
        //(data,mime,encoding)




        setContentView(wv);

    }
}
