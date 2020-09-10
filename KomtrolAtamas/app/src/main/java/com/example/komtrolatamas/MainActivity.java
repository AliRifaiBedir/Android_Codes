package com.example.komtrolatamas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edittext =(EditText) this.findViewById(R.id.edittexID);
        final TextView textview= (TextView) this.findViewById(R.id.textviewID);
        Button button=(Button) this.findViewById(R.id.buttonID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kelime=edittext.getText().toString();
                textview.setText(kelime);
                Toast.makeText(MainActivity.this,"mesaj göderildi",Toast.LENGTH_LONG).show();





            }
        });





            }
        }










