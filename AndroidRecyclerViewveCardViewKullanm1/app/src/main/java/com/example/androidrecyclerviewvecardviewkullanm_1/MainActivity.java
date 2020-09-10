package com.example.androidrecyclerviewvecardviewkullanm_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity<RecylerView> extends AppCompatActivity {
    /*Karamaşık listeler için kullanılır RecyclerView.
    Bi tarafta data var bunu her hangi bi yerden alabilriz
    diğer taraftan görüntelemek isreğimizi recylerview da
    gösterecez ve yine Adapter kullanacaz.

    LayoutManager ise Recycler içinde veriler nasıl sıralanac
    onu beliritiyoruz.
     */


    /* implementation 'com.android.support:cardview-v7:28.0.0'
    //noinspection GradleCompatible
    implementation 'com.android.support:recyclerview-v7:28.0.0'

    Başlamaadan önce bu kodları kopyala gradle ve sync et
    daha sonra androidx.recyclerview.widget.RecyclerView
    ile başla xml de yani Linear faland eğil

     */

    /*YENİ bir xml olusturuk ve root elementi CardView olsun
    row_list adında yaptık biz

     */
    /*MobileOs diye bir sınıf olusturuk ve ekleyeceğmiz verielrin
    tipini açıklayıo getter setter yaptık ve daha sınra mainActibityde
    onlara consturcatır sayesinde verielri ekeldik.
     */


    ArrayList<MobileOs> mobileOs = new ArrayList<>();
    //Böylece mobileos dan arraylist olusturcaz

    RecyclerView recyclerView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyler_view);
        

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        //Veirlerin nasıl konumlanacağını beliritir

        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        //set ettik

        recyclerView.setHasFixedSize(true);
        //PERFORMANI ARTTIRIR

        CustomAdapter customAdapter=new CustomAdapter(mobileOs,context);
        //Adaptör olusturudjk
        recyclerView.setAdapter(customAdapter);

        mobileOs.add(new MobileOs("IOS", "2001", R.mipmap.ic_launcher));
        mobileOs.add(new MobileOs("Apple", "1996", R.mipmap.ic_launcher));
        mobileOs.add(new MobileOs("Android", "2005", R.mipmap.ic_launcher));
        mobileOs.add(new MobileOs("Linux", "1985", R.mipmap.ic_launcher));
        //Böylece 4 veri ekledik


    }
}
