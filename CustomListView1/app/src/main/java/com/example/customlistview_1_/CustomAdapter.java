package com.example.customlistview_1_;

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
    Context context;
    List<MobileOs> mobile = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context _context,List<MobileOs> _mobile) {
        this.mobile = _mobile;
        this.context=_context;
    }


//BaseAdapterden kalıtım aldık ve implement ettik


    @Override
    public int getCount() {
        //ListVİEW de gösterilecek satır sayısı
        mobile.size();
        //Mobile sınıfnda kav tane eleman varsa
        // o kadar satır olsun


        return 0;
    }

    @Override
    public Object getItem(int position) {
        //Position ile sırası gelen eleman

        return position;
    }

    @Override
    public long getItemId(int position) {
        //Şayet varsa niteleyici ID bilgisi
        //Bu şekilde 0 kalabilir
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Position ile sırası gelen satır için bir view döndürür
        //Layout inflater burda kullanacaz
        inflater=LayoutInflater.from(context);

        View satir = inflater.inflate(R.layout.satir, null);//Göstermek istediğimiz layout
        //Burada textVİEW ve İmageVIew ulastık
        TextView textView = satir.findViewById(R.id.txtLogo);
        ImageView image = satir.findViewById(R.id.logo);

        MobileOs mobileOS = mobile.get(position);
        textView.setText(mobileOS.getAdi());

        //İsme Göre iconları atacaz

        if (mobileOS.getAdi().equals("IOS")) {
            image.setImageResource(R.mipmap.ic_launcher);
        } else if ((mobileOS.getAdi().equals("Windows Phone"))) {
            image.setImageResource(R.mipmap.ic_launcher);
        } else if ((mobileOS.getAdi().equals("BlackBarry"))) {
            image.setImageResource(R.mipmap.ic_launcher);
        } else if ((mobileOS.getAdi().equals("Android"))) {
            image.setImageResource(R.mipmap.ic_launcher);
        }


        return satir;//Geriye satırı döndürmesi gerekiyor çünkü metod view döndürüyor
    }
}
