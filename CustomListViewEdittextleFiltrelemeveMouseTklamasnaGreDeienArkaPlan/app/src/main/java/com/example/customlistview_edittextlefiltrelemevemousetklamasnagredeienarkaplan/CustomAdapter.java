package com.example.customlistview_edittextlefiltrelemevemousetklamasnagredeienarkaplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<Airport> airportList = new ArrayList<>();
    LayoutInflater inflater;
    Context context;




    @Override
    public int getCount() {
        //ListVİEW de gösteriecek satır sayısı

        return airportList.size();
        //Custom adapterde 4 satır güzkecek çünkü 4 tane
        //veri girmistik mainActivyde

        // return 0;
    }

    @Override
    public Object getItem(int position) {
        //Poszisyon ile sırarı gelen elemanı gösteriyor
        //return null;

        return position;//Bunu kullanıyoruyz
    }

    @Override
    public long getItemId(int position) {
        return 0;
        //Burası içiçn her hangi bişey yazmaya gerek yok

    }




    //Son olarak activty de ulsamak için constructor olusturudk
    //(Nerde olusturulacak,verileri nreen alacak)
    //sON olarak mainaActivyde cağıracagız
    public CustomAdapter(List<Airport> airportList, Context context) {
        this.airportList = airportList;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //O pozisyon ile sırası gelen satır için bir view döndürüyor
        //Yani o satırda hangi eleman nereye yerleştirceğimizi belirtiyor
        //Burada layoutInFlater ile ne nereye yerleşecek onu yapacaz o yzuden şimdi
        //LAYOUTıNfLATER tanımlayacaz

        inflater = LayoutInflater.from(context);
        View satir = inflater.inflate(R.layout.satir, null);
        ImageView imageView = satir.findViewById(R.id.img);
        TextView txtName = satir.findViewById(R.id.txtName);
        TextView txtLocation = satir.findViewById(R.id.txtLocation);
        //Burada LayoutInflater ile viewlere ulastık

        Airport airport = airportList.get(position);//Dönen değer airport olduğuu içn böyle bir
        //örnekleme aldık
        imageView.setBackgroundResource(airport.getImgSrc());//Böylece değer attık
        txtName.setText(airport.getName()+"("+airport.getCode()+")");//Böylece değer attık
        txtLocation.setText(airport.getCity()+"-"+airport.getCountry());//Böylece değer attık
        return  satir;



        //return null;
    }
}
