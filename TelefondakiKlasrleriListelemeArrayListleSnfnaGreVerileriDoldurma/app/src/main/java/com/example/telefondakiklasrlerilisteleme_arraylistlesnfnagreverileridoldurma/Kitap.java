package com.example.telefondakiklasrlerilisteleme_arraylistlesnfnagreverileridoldurma;

public class Kitap {
    //Şimdi Kitap.java olusturacaz
    int id;
    String baslik;
    String yazar;
    //Getter-Setter yaptık


    public Kitap( ) {
    }

    public Kitap(String baslik, String yazar) {
        this.baslik = baslik;
        this.yazar = yazar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }
}
