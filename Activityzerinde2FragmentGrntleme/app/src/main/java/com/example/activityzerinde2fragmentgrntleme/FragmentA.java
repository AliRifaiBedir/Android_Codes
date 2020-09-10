package com.example.activityzerinde2fragmentgrntleme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentA  extends Fragment {
    //Fragmenttan kalıtım aldıracagız
    //Daha sonra OncreateView metodınu override edecez



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //(custom için,view group,sahnedeki olayalrı akıldatutaubilmek için)
       View view= inflater.inflate(R.layout.fragment_a,container,false);
        //(Hangi layout,hangi viewgrup kullanılcak,false)
        //Yani kısaca burda fragment_a gösterilecek diyorum
        //Burda view adlıdeğişken olusturduk çünkü inflater dönüş tipi view
        return view;
    }
}
