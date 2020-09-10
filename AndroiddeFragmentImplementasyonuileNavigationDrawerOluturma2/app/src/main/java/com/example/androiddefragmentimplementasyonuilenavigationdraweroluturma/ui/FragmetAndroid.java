package com.example.androiddefragmentimplementasyonuilenavigationdraweroluturma.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.androiddefragmentimplementasyonuilenavigationdraweroluturma.R;

public class FragmetAndroid extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_androidfragment,container,false);

        return view;
    }
}
