package com.example.androidwebserviskullanm_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    /*Biz burda web sitesinde bir istekte buluncaz ve ona göre response
    alacaz.Bunn için iki tane teknıloji var istek gönderip response
    almak için.
    1)RESTful:JSON verisi kullanıyor
    2)SOAP:Bu xml teknolojisi kullanıyor
    Json daha sonra çıktı ve daha hızlı işelm yapıyor

    Soap Envelope parametleri
    1)Envelope
    2)HEader
    3)BODY(Bir tek bu zorunlu)

    */

    /*w3schools celcius fahrenheit web servis yazdık google
    orda celcius değeri girince fahrenhier değeri dönüyor bize

    Soap envelop içinde celcius tagleri arası bir string deper yollamışlar
    response olarak da strin cevap veriyorlar bunu uygulamaya calısacaz

    Bizim amacımız edittex celcius değeri gircez ve dönen değer olarak
    bize fahrnhiet olarak en altta textview de görünecek


     */


    Button btnConver;
    TextView txtSonuc;
    EditText etGiris;
    final String NAMESPACE = "https://www.w3schools.com/xml/";//WebServisin isim alanı
    //Bunu weschollsda xmlns= kısmını aldık ve çok önemli

    final String URL = "https://www.w3schools.com/xml/tempconvert.asmx";
    //Çağıracağımızn serivisin url bilgisi.Soru işareti kısmına kadar kopyaladık

    final String SOAP_ACTION = "https://www.w3schools.com/xml/CelsiusToFahrenheit";
    //Bu iki yerin birleşmiş hali bu

    final String METHOD_NAME = "CelsiusToFahrenheit";
    //Buraya baktığımızda NAMESPACE+METHOD_NAME SOAP ACTION olustuuyıruor

    String celsius;
    String fahren;

    /*ksoap2 kütüphanesini indirdik java2s ten, amacı webservilerini çağırmak
    ve işi kolaylaştırmak.



    Peki projeye nasıl dahil edecez:Project kısmını açıyoruz app/lip içinde
    showinexplorer diyoruz indirdiğimiz kütüphaneyi zip halini aldık av ayıkladık daha sonra
    açılan dosyada ismin tamamını kopyalıyacaz.Daha sonra android kısmına gelip build.gradle
    (Moduleapp kısmında dependecies yapısının altına compile files(' kopyalanan isim') yaızıyooız
    ve senkronize ediyoruz.Böylece kütüphane eklenmesini öğrendik

    */
    //İnternet iznini vermeyi unutma  <uses-permission android:name="android.permission.INTERNET"/>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConver = findViewById(R.id.btnConvert);
        txtSonuc = findViewById(R.id.txtSonuc);
        etGiris = findViewById(R.id.etGiris);
        btnConver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etGiris.getText().length() != 0 && etGiris.getText().toString() != null) {
                    celsius = etGiris.getText().toString();//Girilen değeri celsüusa attık
                    //İnternet bağlantısı olacağı için asenkron task ile yapacaz ve burda
                    //çalısıtırcaz ama işler asenkrontaskta olacak

                    //async.execute
                    AsyncCallWS task=new AsyncCallWS();
                    task.execute();


                } else {
                    txtSonuc.setText("Lütfen Celsiue Değerini Giriniz");
                }
            }
        });


    }


    //bURADA ŞİMDİ FARKLOI BİR CLASS OLUSTURUDUK VE OVERRİDE İLE METODLARI EKLEDİK
    //AsyncTask kalıtımı aldık ve websitesinde parametre Strin olduğu için
    //biz de metodalrın parametresini Objectten Stringe çeviriiyoruz

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        //<doINbackGround,onPostEXECUTE,oNPROGRESsUpdate> şeklinde parametreli doldurduk

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtSonuc.setText("Hesaplanıyor");
            //Web servisinş çağırmadan önce ne yapsın
        }

        @Override
        protected Void doInBackground(String... params) {
           getFahrenheit(celsius);
            return null;
        }

        @Override
        protected void onPostExecute(Void o) {
            super.onPostExecute(o);
            txtSonuc.setText(fahren + " F");
            //İşlem bittikten sonra bunu göstersin
        }

        @Override
        protected void onProgressUpdate(Void[] values) {
            super.onProgressUpdate(values);
            //İşlem sırasında bi şey göstermek istemeiğöiz için bişey yapmadık burada
        }


    }

    public void getFahrenheit(String celsius) {
        //Biz şimdi burda ksoap2 nin özelliklerini kullanacaz
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //iSTEK BULUNMAK İÇİN HAZIRLIKLAR

        PropertyInfo celsiusPi = new PropertyInfo();
        //CelsiusPi.setName("Celsius"); Burada ki celsius sitedeki paramatre Celsius olduğu için
        //CelsiusPi.setValue(celsius); celsius yuakrıda parametre olan celsius bizim tanımladığımz
        //Celsiuspi.SetType(double.class)// burada veriniin tipi
        //request.addProperty(celsiusPi); Property infoyu buraya ekledik
        //Burada requesti hazırladık . Mektubun içni hazırladık


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        //Mejtubun içine koyduk

        HttpTransport httpTransport = new HttpTransport(URL);
        try {
            httpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive response= (SoapPrimitive) envelope.getResponse();
            fahren=response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
