package com.example.intentkullanarakvideoveresimekmek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
/*Video ve resim de kamera kullanması için kamera aps için
intent kullanıyor.
 */
// <uses-permission android:name="android.permission.CAMERA"/> izni ver
//Biz startActivit resault ile gönderdik asıl önemli olan çektiğimiz
// fotoğraf ya da video ile ne yapacaz onu da OnCreate dışında tanımlıyoruz
    //onActivityReasult ile

    Button btnFotoCek, btnVideoCek;
    ImageView imgOnIzle;
    VideoView videoOnIzle;
    static int IMAGE = 100;
    static int VIDEO = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFotoCek = findViewById(R.id.btnFotoCek);
        btnVideoCek = findViewById(R.id.btnVideoCek);
        imgOnIzle = findViewById(R.id.imgOnIzle);
        videoOnIzle = findViewById(R.id.videoOnIzle);

        btnFotoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Fotoğraf çekilcek uygulamsı açılacak
                startActivityForResult(intent, IMAGE);


            }
        });

        btnVideoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                //Video çekilcek uygulamsı açılacak
                startActivityForResult(intent, VIDEO);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMAGE){
            //Eğer cektiyese foto ımageview de gösterasin
            Bundle bundle=data.getExtras();
            Bitmap bitmap= (Bitmap) bundle.get("data");
            imgOnIzle.setImageBitmap(bitmap);

        }
        if (requestCode==VIDEO){
           videoOnIzle.setVideoURI(data.getData());
           videoOnIzle.setMediaController(new MediaController(this));
           videoOnIzle.requestFocus();
           videoOnIzle.start();


        }
    }
}
