package com.example.sharedprfenreceslebenihatirla_sharedpreferencessnfolusturma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    CheckBox chkRememberMe;
    Button btnLogin;
    sredPrefernc sredPrefernc;//Bir tane örnekleme aldık
    Context context = this;

    //Başlangıç aktivitemiz loginActivty bunu tanıtmayı unutma Manifestte


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        if (sredPrefernc.getValueBoolean(context,"remember")){//Beni
            //hatırla işaretlenmişse yani aşağıdaki kodda kontrol edip kaydetmştik
            etUserName.setText(sredPrefernc.getValue(context,"username"));
            chkRememberMe.setChecked(sredPrefernc.getValueBoolean(context,"remember"));



        }




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ayrıca string xml de string ile test_username ve test_password
                //değerlerini tanımladık ve isim "ismek" ,sifre"1" ise giris yapsın
                //yapacaz

                if (etUserName.getText().toString().equals(getString(R.string.test_username)) && etPassword.getText().toString()
                        .equals(getString(R.string.test_password))) {
                    //Eğer burda bu doğruysa giriş tuşuna basınca 2.aktiviteye gidecek
                    Intent intnt = new Intent(context, MainActivity.class);
                    startActivity(intnt);
                    //Şimdi burdan sonra Shared Prefernce olayını halletmem lazım
                    //Eğer cehckBox işaretli ise kullanıcı adını girdiği değeri kaydedecez
                    if (chkRememberMe.isChecked()) {
                        sredPrefernc.save(context, "username", etUserName.getText().toString());
                        //Şu an chkbox işaretli ise "username" etiketi ile kayıt olacak veri
                        //(context,key,Hangi veri kaydedilecek)


                    }else{
                        //Eğer işaretli değilse hiçbir şey yazmayacak
                        sredPrefernc.save(context,"username","");

                    }
                    sredPrefernc.saveBoolean(context,"remember",chkRememberMe.isChecked());
                    //Burada checkbOX kontrol ediyoruz ve değeri kaydediyoruz






                } else {
                    //Buradaki mesajı  da string xml de tanıttık


                    Toast.makeText(context, getString(R.string.login_eror), Toast.LENGTH_LONG).show();
                }


            }
        });


    }


    public void init() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        chkRememberMe = findViewById(R.id.chkRememberMe);
        btnLogin = findViewById(R.id.btnLogin);
        sredPrefernc = new sredPrefernc();
        //Bunu yaptıktan sonra şimdi sredPreferen sınıfının
        //bütün metodlarını kulanabilirim

    }


}
