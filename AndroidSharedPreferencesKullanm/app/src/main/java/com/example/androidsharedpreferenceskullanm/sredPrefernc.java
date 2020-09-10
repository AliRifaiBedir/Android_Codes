package com.example.androidsharedpreferenceskullanm;

import android.content.Context;
import android.content.SharedPreferences;

public class sredPrefernc {
    static final String PREF_NAME = "Dosya";//Dosyamızn ismi
    final String PREF_KEY = "Key";


    //Key value şeklinde oluyor ve sonsuza kadar olacak

    public void save(Context context, String text) { //String değer kaydetmek için

        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        //Burada SharedPrefernces sınıfndan dosya olustrudk ve olusan dosyaya dişardan
        //ulaşılmasını istemediğimiz için mode PRIVATE seçtik

        SharedPreferences.Editor editor = settings.edit();
        //Burda döen değer editör olduğu için editör adında örnekleme aldık.
        //Bu neye yarar:Hmap anahtar key value verilerin eklenmesini
        //bir xml dosyasına kaydedilmesini sağlar

        editor.putString(PREF_KEY, text);
        editor.commit();


    }

    public String getValue(Context context) {//String değeri elde etmek için
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        //İster değer kaydedin ister kaydettiğniz değeri elde edin bu her halükarda kullanılacak

       String text= settings.getString(PREF_KEY,null);
       //Geriye text değer geldiği için sTring değişkeni olusturduk
        //Metod String döndüğü için oldu
       return  text;


    }

    //Bütün Shared Prefernces sınıfında  kullanacağımız iki şey var
    //bir tanesi Preferecensteki değerleri temizlemek

    public  void clear(Context context){//Temizlemek için
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();

    }
    public  void remove(Context context){//Bu da nesneyi kaldırıyor
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(PREF_KEY);//Burda anahtarı isitiyor.
        editor.commit();
    }






}
