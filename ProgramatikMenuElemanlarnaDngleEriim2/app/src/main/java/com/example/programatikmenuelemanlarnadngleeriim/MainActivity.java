package com.example.programatikmenuelemanlarnadngleeriim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/*Döngü ile array list olustuurup onlara döngü ile ulaşıp onlara
iş yaptıracağız.Menu xml yok biz kendimiz empty aktivicy ile yapacaz
 */
//Şimdi ayrıca başka bir SecondActivty kuracaz ve aynı şeklide
//menüler orda da olacak bunun için xml de bir buton tanımlayıp
//bunu manifeste ekleyecez ve intent ile geçişi yapacaz.


//Burada olan bütün menü olusturma kodları ayarlar activitye
//taşındı ve şimdi kalıtım ile alacaz hepsini
//Amacımız 15 tane olsa activity hepsi çiçn tek tek kopyalama
//mak için böyle bir yöntem sectik


//Manifestte ayarlar activity eklemeyi ununtmayın


public class MainActivity extends AyarlarActivty {
    Context context=this;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button=findViewById(R.id.btnID1);
        setContentView(R.layout.activity_main);
        button.setOnClickListener(new View.OnClickListener() {//Butona tıklayınca intent ile diğer activtye
            //gidiyoruz.
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SecondActivity.class);
                startActivity(intent);

            }
        });




    }



}