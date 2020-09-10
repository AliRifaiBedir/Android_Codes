package com.example.tablayoutviewpagervefragmentkullanm_1_ders159;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpelFragmentPageAdapter extends FragmentPagerAdapter {
    private  String[] tabTitle=new String[] {"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6","Tab7","Tab8","Tab9","Tab10"};

    Context context;
    public SimpelFragmentPageAdapter(@NonNull FragmentManager fm, Context context) {


        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
        //Pozisyonuyla gelen gragment gösterilcek
        FragmentDemo fragmentDemo=new FragmentDemo();
            return fragmentDemo;}
        else  {FragmentDemo2 fragmentDemo2=new FragmentDemo2();
        return fragmentDemo2;}



    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //Başlık isimleri tek tek görüncek
        return tabTitle[position];
    }

    @Override
    public int getCount() {
        //dÖNECEK ELEMAN SAYISI
        return tabTitle.length;
    }
}
