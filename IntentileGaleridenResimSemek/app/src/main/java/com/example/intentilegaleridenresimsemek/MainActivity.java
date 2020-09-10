package com.example.intentilegaleridenresimsemek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button selectImage;
    ImageView imageView;
    static final int SELECT_IMAGE = 12;
    Uri imageUri;
    /*Resim eç butonuna tıkaldğımızda galeri açılacak
    ve ordan resim seçinde bizim imageview in arka plan resmi olcak


     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectImage = findViewById(R.id.selectImage);
        imageView = findViewById(R.id.imageView);

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //Her hangi bir dosya seçmek için kulalnılır.
                //Dosya ya da resim gibi

                intent.setType("image/*");
                //Böylece hangi tür olacağını seçtik

                startActivityForResult(intent, SELECT_IMAGE);
                //(intent,sabit sayı) TALEBİ YOLLADIK


            }
        });


    }

    @Override
    //onCREATE dışında yapacaz
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SELECT_IMAGE && requestCode == RESULT_OK) {
            //(İNTENT KODUMUZ,YAPTIĞMIZ İŞ BAŞARILI İSE YANİ KULLANICI RESİM SEÇTİYSE)
            imageUri = data.getData();
            //dÖNEN DEĞER URİ FOTONUN
            imageView.setImageURI(imageUri);


        }else if (resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Resim Seçme İptal Edildi", Toast.LENGTH_SHORT).show();
        }
    }
}