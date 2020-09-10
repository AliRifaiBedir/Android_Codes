package com.example.androidvideoviewkullanm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    /*Anndroidde video oynatmak için videoview sınıfı kullncaz

     */
    VideoView videoView;
    ProgressDialog progressDialog;
    Context context = this;
    MediaController mediaController;
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Video oynatılmsı için gerekn butonlar eklendi böylece
        if (mediaController == null) {
            mediaController = new MediaController(context);
        }
        videoView = findViewById(R.id.videoIzle);

        //DİREK DEĞİLDE DİALOG PENCERESİ ŞEKLİNDE GÖSTERELİM
        //Başlangçta progressdialog gösterilcek
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Android VideoView Örneği");
        progressDialog.setMessage("Yükleniyor");
        progressDialog.setCancelable(false);
        progressDialog.show();


        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + R.raw.kolo));
        //raw içerisine böyle ulasşıyoruz hangi video göterilcekse
        videoView.requestFocus();


        //Video gösterilcemedn önce yapolmasını istediğimiz şeyler
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                progressDialog.dismiss();//progres kapansın
                videoView.seekTo(position);//Son kapatılan playerın kaldığı yeri tespit ediyor
                //Ama onu yakalyacaz ve onCREATE DIŞINDA YAPALIM ONU
                if (position == 0) {
                    videoView.start();
                } else {
                    videoView.pause();
                }


            }
        });


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        //  Videonun sson konumunu saklamak için kullanılabir

        outState.putInt("positionnn", videoView.getCurrentPosition());
        videoView.pause();

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //Burda da videonun kaldığı yerde devam edebilmesi içn
        position=savedInstanceState.getInt("positionnn");
        videoView.seekTo(position);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
