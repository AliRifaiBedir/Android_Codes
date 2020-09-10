package com.example.androidkonumservisleri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    /*Mobil cihazlar iiçn 3 farkloı şekilde kullanılabilr konum
    bilgileri;
    1)GPS:Kapalı mekanlarda çalışmaz ve pil tüketimi fazla
    2)NEtwork provider:İç ve Dış mekanlarda çalışır baz istasyonları sayesşnde
    3)Pasive:İşletim sisteminin eskiden tuttuğu bilgilere göre yapar
    */

    //İki tane text enlem ve boylam adında tanımladık ve GPS
    //ile bu değerleri alacağız.Konum servislerini kullanacaz

    /* <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    <uses-permission android:name="android.permission.INTERNET"/>

    vERECEĞİMİZ İZİNLER BUNLAR

    */

    TextView txtEnlem, txtBoylam;
    LocationManager locationManager;//Kullandığımız sınıf,Çekirdek sınıfımız
    //Bir sistem serviisidir coğrafi konum bilgileri alınması içim alınnançekirdek sınıftır
    //context kullanarak alınır.

    String provider;//Servis sağlayıcımız, bize gps bilgileri ağlayan sevisimiz


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBoylam = findViewById(R.id.txtBoylam);
        txtEnlem = findViewById(R.id.txtEnlem);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Bir sistem serviisidir coğrafi konum bilgileri alınması içim alınnançekirdek sınıftır
        //context kullanarak alınır.

        Criteria criteria = new Criteria();
        //Provider için criteria olusturudk burada
        provider = locationManager.getBestProvider(criteria, false);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        //Mesela provider kapalı uygulamada hata olmasın diye bunu yaptık
        //Yuakrıda iziznler ile ilgili bir if bloğu çıkıyor
        //Komun bilgimiz location da

        if (location != null) {
            //onLocationChanged
            onLocationChanged(location);


        } else {
            //Location bilgileri elde edilmemişse
            txtEnlem.setText("Not Avaliable");
            txtBoylam.setText("Not Avaliable");

        }


    }



    @Override
    protected void onPostResume() {
        //Uygulamamız çalışmaya devam ederken
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }//İzin uyarısı  locationManager.requestLocationUpdates(provider, 100, 1, this); için

        locationManager.requestLocationUpdates(provider, 100, 1, this);
        //(provider,lokasyon almak için gerekekn min süre,loksayon için alınması gerekn min mesafe
        //Belirlenen zaman içinde aktüel lokasyon verilerini almayı sağlar
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        //Uygulama durudğunda konum bilgileri alınmaması için
        //yani uygulamayı kapatınca olacak olaylar
        locationManager.removeUpdates(this);
        super.onPause();
    }

    @Override
    public void onLocationChanged(Location location) {
        //Konum güncellemesi olduğunda tetikleniyor
        double lat = location.getLatitude();
        double log = location.getLongitude();
        txtEnlem.setText(String.valueOf(lat));
        txtBoylam.setText(String.valueOf(log));

        //Böylece her konum değiştiğinde bu datalırın değiştiğini sürekli grcez


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //Konum bilgisi servisin durumu değiştiğnde tetiklenir

    }

    @Override
    public void onProviderEnabled(String provider) {
        //Servis sağlayıcımız aktiflendiğnde tetkilenir
        Toast.makeText(this, "Enable Provider", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        //Servis sağlayıcımız pasifleştiğinde tetkilenir
        Toast.makeText(this, "Disable Provider", Toast.LENGTH_SHORT).show();


    }
}



// Burada bizim provider dediğmiz şey aslında telefonda konum aracını enable etmek ya da disable edince
//anlıyoruz
