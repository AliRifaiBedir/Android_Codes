package com.example.androidrecylerviewvecardvewkullanm_swiperefreshlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    //Kızarıklık için implement yaptık 3 metod için
    ArrayList<MobileOs> mobileOsArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    class ViewHolder extends RecyclerView.ViewHolder {
        //ZORUNLUDUR VE PERFORMANSI ARTTIRMAK İÇİN

        //View hodler sınıfı bu şekilde olustruduk bunun sayesinde
        //eskisi gibi her satır içiçn dolaşmaya gerek kalmayacak
        TextView txtAciklama, txtCikisTarihi;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAciklama = itemView.findViewById(R.id.txtAciklama);
            txtCikisTarihi = itemView.findViewById(R.id.txtCikisTarihi);
            imageView = itemView.findViewById(R.id.image);
            linearLayout = itemView.findViewById(R.id.LinearLoyut);
        }
    }


    public CustomAdapter(ArrayList<MobileOs> mobileOsArrayList, Context context) {
        //Burada constructor olusturudk önemli olan biizim için
        //verielr nerden oluscak ve nerde oluscak o yuzden bu ikisinş aldık
        this.mobileOsArrayList = mobileOsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Her bir satır için temsil edilecek arayüz seçilir
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.row_list, parent, false);
        //(Hangi xml düzenlenecek,viewgrop,boolean)
        ViewHolder vh = new ViewHolder(v);
        //Buradaki v yi viewHoldera döndürdük
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Herbir görünümümn içeriği belirlenecek
        holder.txtAciklama.setText(mobileOsArrayList.get(position).getAciklama());
        holder.txtCikisTarihi.setText(mobileOsArrayList.get(position).getCikisTarihi());
        holder.imageView.setImageResource(mobileOsArrayList.get(position).getImgSrc());

        holder.linearLayout.setTag(holder);
        //Bu sayede her satıriçin findBYid gerek kalmadı

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            //En dıştaki lineara tıklayınca ne olacak
            @Override
            public void onClick(View v) {
                ViewHolder holder = (ViewHolder) v.getTag();
               int position= holder.getPosition();
               String aciklama= mobileOsArrayList.get(position).getAciklama();
                Toast.makeText(context,aciklama,Toast.LENGTH_LONG).show();



            }
        });


    }

    @Override
    public int getItemCount() {
        //Burada mAİNaCİTİVYDE MOBLİEOS 4 tane attık
        //yani onun size kadar döndür diyecez


        return mobileOsArrayList.size();
    }


}
