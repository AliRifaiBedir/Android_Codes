package com.example.androidxmlrssreader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    ListView listView;
    ArrayList<String> xmlList = new ArrayList<>();
    ArrayList<String> xmlLink = new ArrayList<>();
    ArrayList<String> xmlImg = new ArrayList<>();




    /*Rss reader için bilinen bir siteye git en başta veya
    en sonda Rss tıkla.
    Rss:Yeni eklenen içeriğe kolayca ulaşabilmek.Mesela
    o siteye yeni bir haber,makale düştüğünde sana hemen haber
    geliyor.
     */
   /*Biz şimdi son dakika RSS almak isityoruz
   BUrada iki aktivity var.Listview de btün başlık
   bütün haberler listelensin.Fakat nasıl listelensin
   bunu listte custom olarak solda haberin resmi
   sağda haberin başlığı.A

   Aynı zamanda habere tıkladığğımızda da habere gönderecek
   yani linkini de almamız lazım.

   1)İMAGE
   2)TİTLE
   3)LİNK
   bilgilerine ulaşmamız lazım
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new arkaPlanIsleri().execute();
        //Bunu en son yapıyotuz


        listView = findViewById(R.id.list);

        //Burada listelenen elemana tıklayınca tıkalanan habere gönderecek
        //Bu yüzden xmlLink çalıştırmamız lazım
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Burada listelenen elemana tıklayınca tıkalanan habere gönderecek
                //Bu yüzden xmlLink çalıştırmamız lazım.Bütn bilgiler arraylist
                //halinde dönmesi lazım çünkü eleman sayısnı bilmiyoruz

                Uri link = Uri.parse(xmlLink.get(position));
                Intent opernBrowser = new Intent(Intent.ACTION_VIEW, link);
                startActivity(opernBrowser);
                //Böylece haber geldiğimde habere tıkaldığımzda haberre gidecez


            }
        });


    }

    //Biz bu sınıfı customAdpetre olacak layoutInflater ile ulaşıp özellştircez
    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<String> xmlList) {
            super(context, textViewResourceId, xmlList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                row = layoutInflater.inflate(R.layout.list, parent, false);
                //(hangi liste,ViewGroup,false)
                //Böylece xmlList teki list biizm row oldu


            }
            TextView textView = row.findViewById(R.id.text);
            textView.setText(xmlList.get(position));
            //Pozisyonuyla gelen elemanı gösteiyor


            ImageView imageView = row.findViewById(R.id.img);
            imageView.setImageResource(R.mipmap.ic_launcher_round);

            return row;

        }
    }

    public class arkaPlanIsleri extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog = new ProgressDialog(context);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Yükleniyor");
            dialog.show();
            //Haberler gelmeden önce bu çıkacak
        }

        @Override
        protected Void doInBackground(Void... params) {
            xmlList = getListFromXml("https://www.milliyet.com.tr/rss/rssnew/sondakikarss.xml");
            //Siteinin adresini kopyaladık yani string gönderdik ve bize dizi döndürdü
            xmlLink = getListFromXml("https://www.milliyet.com.tr/rss/rssnew/sondakikarss.xml");

            return null;
            //               xmlImg=
        }

        @Override
        protected void onPostExecute(Void o) {
            //İşelem bittikten sonra
            MyCustomAdapter adapter = new MyCustomAdapter(context, R.layout.list, xmlList);
            listView.setAdapter(adapter);
            dialog.dismiss();


            super.onPostExecute(o);
        }


    }


    public ArrayList<String> getListFromXml(String STRNG) {
        //sTRİNG DEĞERİ BURDA BİZİM URL ASLINDA
        ArrayList<String> list = new ArrayList<>();


        try {
            URL url = new URL(STRNG);
            DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
            //Ayrıştırıcı çağıramya çalışıyoruz

            DocumentBuilder dBuilder = dfactory.newDocumentBuilder();

            Document document = dBuilder.parse(new InputSource(url.openStream()));
            //Dönen değer docement olduğu için değişken tanımladık

            document.getDocumentElement().normalize();
            //XML den bilgi çekerken üstteki 4 lodu kullanıyoruz
            //daha sonra for ile elemanalra ulaşacaz

            NodeList nodeListItem = document.getElementsByTagName("item");
            //Burada bütün ıtemları çekiyoruz şimdi for ile title bilgisine ulaşalım

            for (int i = 0; i < nodeListItem.getLength(); i++) {
                Node node = nodeListItem.item(i);
                //Böylece ilk elemanı aldık

                Element elementMain = (Element) node;
                //node çevirdik

                NodeList nodeListTitle = elementMain.getElementsByTagName("title");
                //Böylece item içindeki hangi tagi alacağımızı söylyırz

                Element elementTitle = (Element) nodeListTitle.item(0);
                //Böylece elemtTitleda verimiz bulunuyor
                list.add(elementTitle.getChildNodes().item(0).getNodeValue());
                //bÖYLECE DEĞERİ arrayliste attık

                //Burada item içinde dolaşıp tittle içindeki ilk veriyi
                //alıp diziye ekliyor ve bu metod geri diziyi döndürüüyr


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;//En son bunu yaptık

    }

    public ArrayList<String> getListLinkFromXml(String STRNG) {
        //sTRİNG DEĞERİ BURDA BİZİM URL ASLINDA
        //Burada da aynı kodu kopyaladık ve ismi değiştirdik
        //amacımız item içindeki link bilgisine ulaşacaz
        ArrayList<String> list = new ArrayList<>();


        try {
            URL url = new URL(STRNG);
            DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
            //Ayrıştırıcı çağıramya çalışıyoruz

            DocumentBuilder dBuilder = dfactory.newDocumentBuilder();

            Document document = dBuilder.parse(new InputSource(url.openStream()));
            //Dönen değer docement olduğu için değişken tanımladık

            document.getDocumentElement().normalize();
            //XML den bilgi çekerken üstteki 4 lodu kullanıyoruz
            //daha sonra for ile elemanalra ulaşacaz

            NodeList nodeListItem = document.getElementsByTagName("item");
            //Burada bütün ıtemları çekiyoruz şimdi for ile title bilgisine ulaşalım

            for (int i = 0; i < nodeListItem.getLength(); i++) {
                Node node = nodeListItem.item(i);
                //Böylece ilk elemanı aldık

                Element elementMain = (Element) node;
                //node çevirdik

                NodeList nodeListTitle = elementMain.getElementsByTagName("link");
                //Böylece item içindeki hangi link alacağımızı söylyırz

                Element elementTitle = (Element) nodeListTitle.item(0);
                //Böylece elemtTitleda verimiz bulunuyor
                list.add(elementTitle.getChildNodes().item(0).getNodeValue());
                //bÖYLECE DEĞERİ arrayliste attık

                //Burada item içinde dolaşıp tittle içindeki ilk veriyi
                //alıp diziye ekliyor ve bu metod geri diziyi döndürüüyr


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;//En son bunu yaptık

    }



}
