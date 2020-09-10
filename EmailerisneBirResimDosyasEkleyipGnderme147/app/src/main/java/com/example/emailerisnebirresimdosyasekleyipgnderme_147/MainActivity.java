package com.example.emailerisnebirresimdosyasekleyipgnderme_147;

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
    Button selectImage,btnEmail;
    ImageView imageView;
    final static int SELECT_IMAGE=12;
    Uri imageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectImage = findViewById(R.id.btnResimsec);
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


        //Email tuşuna basınca olacak olayalr
        btnEmail.setOnClickListener(new View.OnClickListener() {
            //doğru olanı bir metod yazıp burada çağıralım
            //Böylece mail gönderirlir

            @Override
            public void onClick(View v) {
                EmailYolla(new String[]{"rifai_bedir_80@hotmail.com"},"Android Eğitimi","Android ile Mail Gönderme"
                ,imageUri);

            }
        });




    }

    public  void EmailYolla(String[] adressess,String subject,String emailBody,Uri attachment){
        //(adres,başlık,mail,içerik)
        Intent intent=new Intent(Intent.ACTION_SEND);
        //bİR ŞEYYLERİ GÖNDEREMK VE PAYLAŞMAK İÇİN KULLLANIYORUZ ACTIPN SEND

        intent.setType("*/*");
        //hER TÜRLÜ VERİ PAYLAŞILABİLİR DİYORUZ
        intent.putExtra(Intent.EXTRA_EMAIL,adressess);
        //Emailin göndereceği adresle böyle tanımlanır

        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        //Email Başlığı
        intent.putExtra(Intent.EXTRA_TEXT,emailBody);
        //İçerik
        intent.putExtra(Intent.EXTRA_STREAM,attachment);
        //Uri tanımlaması her hangi bir dosya için

        startActivity(intent);
        //maili yolladık





    }



    @Override
    //onCREATE dışında yapacaz
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == SELECT_IMAGE && requestCode == RESULT_OK) {
            //(İNTENT KODUMUZ,YAPTIĞMIZ İŞ BAŞARILI İSE YANİ KULLANICI RESİM SEÇTİYSE)
            imageUri = data.getData();
            //dÖNEN DEĞER URİ FOTONUN
            imageView.setImageURI(imageUri);


        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Resim Seçme İptal Edildi", Toast.LENGTH_SHORT).show();
        }
    }
    }

