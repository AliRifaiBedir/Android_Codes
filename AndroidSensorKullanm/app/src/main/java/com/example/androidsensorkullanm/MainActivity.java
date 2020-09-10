package com.example.androidsensorkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Nrde olduğumuz ortam basıncı,sıcaklık,telefonu
    kuşağımıza gönderdiğiöizde ekranın kapanması yada
    kapalı ortanlarda ışık seviyesini artıp azalması
    çeşitli eksenlerle yapılan hareketlerin takibi gibi
    konum sensörü,hareket sensörü,çevresel sensörler gibi
    daha bir çok sensör var.Hepsini sensor isimli bir sınıf temsil ediuor

     */
   /*Biz şimdi axelometr ile x,y,z ile x yönüne falan hareket
   edince değeri verecek ya da x belli değeğrde hareket edince
   telefon titreyecek
    */


    //  <uses-permission android:name="android.permission.VIBRATE" /> izni
    TextView txtX, txtY, txtZ;
    SensorManager sm;
    Context context = this;
    Sensor sensor;
    SensorGozlemcisi gozlemcisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init() {
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);
        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        //bÖYLECE BAŞLANGIÇ DEĞERİ OLUSTURUDK

        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Böylece ivmeölçer sensörü kullanacağımıızı belirttik

        gozlemcisi = new SensorGozlemcisi();
        //Örenekleme aldık kullanmamız için

        sm.registerListener(gozlemcisi, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        //(sensör event listener,sensör adı,tepkime hızı)
        //Bunu yapmazssak ekranda bişey göreemyiz


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sm.unregisterListener(gozlemcisi);
        //Burasını daha spnra uygulama ile işmiz bitince
        //kapansın diye yani fazla batarya bitmeisn diye
        //yani sensörü falan kapatık
    }

    //Bir tane sınıf tanımladık
    public class SensorGozlemcisi implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float sensor_verileri[] = event.values;
            //Dönüş tipi float dizi verisi olduğu için tanımladık
            //event sensörün algıladığı veri

            txtX.setText("X: " + sensor_verileri[0]);
            txtY.setText("Y: " + sensor_verileri[1]);
            txtZ.setText("Z: " + sensor_verileri[2]);
            //bÖYLECE X Y Z DEĞER VERİLERİ ALINIYOR
            //Telefonu her oynattığımda değerler değişecek

            int x = (int) sensor_verileri[0];
            if (x >= 2 || x <= -2) {
                ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(300);
                //2 ile -2 arasında kaldığı sürece titreyecek
            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //Burda elde edilen değerin doğruluğunıu ifade ediyor
            //(sensor:Birden fazla sensörü ayrımak için,doğruluğu ifade ediyor)
            //Gelen veri her değiştiğinde çalışır
            switch (accuracy) {
                case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                    Log.i("onAccuracyChanged", "Yüksek Doğruluk :" + accuracy);
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                    Log.i("onAccuracyChanged", "Orta Doğruluk :" + accuracy);
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                    Log.i("onAccuracyChanged", "Düşük Doğruluk :" + accuracy);
                    break;
            }

        }
    }


}
