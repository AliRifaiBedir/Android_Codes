package com.example.activityzerinde2fragmentgrntleme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        //(custom için,view group,sahnedeki olayalrı akıldatutaubilmek için)
        //(Hangi layout,hangi viewgrup kullanılcak,false)
        //Yani kısaca burda fragment_b gösterilecek diyorum
        //Burda view adlıdeğişken olusturduk çünkü inflater dönüş tipi view

        return view;
    }
}
