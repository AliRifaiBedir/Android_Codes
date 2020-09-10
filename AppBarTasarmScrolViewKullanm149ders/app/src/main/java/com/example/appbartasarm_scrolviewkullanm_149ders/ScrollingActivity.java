package com.example.appbartasarm_scrolviewkullanm_149ders;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
    //Burda tasarımda empty değil scROLLVİEW SECİYORUZ UNUTMA
    //Nested ScrollView ile birden fazla scroll kullanabilyiruz
    //scrollview den farkı bu zaten

    Context context=this;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show(); Burayı değiştirmek için yorum yaptık onu

                  .setAction("Action", new View.OnClickListener() {
                      //Burda tıklayınca sms işaretine orda Action butonu çıkınca ona tıklayınca
                      //ona tıklayınca bize aşağıdaki Toast mesajını verecek

                      @Override
                      public void onClick(View v) {
                          Toast.makeText(context,"FAB butonu tıklandı",Toast.LENGTH_LONG).show();
                      }
                  }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
