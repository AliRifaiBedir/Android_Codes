package com.example.sharedprfenreceslebenihatirla_sharedpreferencessnfolusturma;

import android.content.Context;
import android.content.SharedPreferences;

public class sredPrefernc {
    static final String PREF_NAME = "Login";//Dosyamızn ismi


    public void save(Context context, String key,String value) { //String değer kaydetmek için

        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        //Burada SharedPrefernces sınıfndan dosya olustrudk ve olusan dosyaya dişardan
        //ulaşılmasını istemediğimiz için mode PRIVATE seçtik

        SharedPreferences.Editor editor = settings.edit();
        //Burda döen değer editör olduğu için editör adında örnekleme aldık.
        //Bu neye yarar:Hmap anahtar key value verilerin eklenmesini
        //bir xml dosyasına kaydedilmesini sağlar

        editor.putString(key, value);
        editor.commit();


    }

    public void saveBoolean(Context context, String key,Boolean value) { //String değer kaydetmek için

        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        //Burada SharedPrefernces sınıfndan dosya olustrudk ve olusan dosyaya dişardan
        //ulaşılmasını istemediğimiz için mode PRIVATE seçtik

        SharedPreferences.Editor editor = settings.edit();
        //Burda döen değer editör olduğu için editör adında örnekleme aldık.
        //Bu neye yarar:Hmap anahtar key value verilerin eklenmesini
        //bir xml dosyasına kaydedilmesini sağlar

        editor.putBoolean(key, value);
        editor.commit();


    }





    public String getValue(Context context, String key) {//String değeri elde etmek için
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        //İster değer kaydedin ister kaydettiğniz değeri elde edin bu her halükarda kullanılacak

        String text= settings.getString(key,null);
        //Geriye text değer geldiği için sTring değişkeni olusturduk
        //Metod String döndüğü için oldu
        return  text;


    }


    public Boolean getValueBoolean(Context context, String key) {//String değeri elde etmek için
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        //İster değer kaydedin ister kaydettiğniz değeri elde edin bu her halükarda kullanılacak

        Boolean text= settings.getBoolean(key,false);
        //Geriye text değer geldiği için sTring değişkeni olusturduk
        //Metod String döndüğü için oldu
        return  text;


    }

    //Bütün Shared Prefernces sınıfında  kullanacağımız iki şey var
    //bir tanesi Preferecensteki değerleri temizlemek

    public  void clear(Context context){//Temizlemek için herhangi bir değişiklik yok
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();

    }
    public  void remove(Context context,String key){//Bu da nesneyi kaldırıyor
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);//Burda anahtarı isitiyor.
        editor.commit();
    }







}
