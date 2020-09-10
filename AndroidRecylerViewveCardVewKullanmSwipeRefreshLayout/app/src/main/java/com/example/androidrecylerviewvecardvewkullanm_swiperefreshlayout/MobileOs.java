package com.example.androidrecylerviewvecardvewkullanm_swiperefreshlayout;

public class MobileOs {
    String aciklama;
    String cikisTarihi;
    int imgSrc;

    public MobileOs(String aciklama, String cikisTarihi, int imgSrc) {
        this.aciklama = aciklama;
        this.cikisTarihi = cikisTarihi;
        this.imgSrc = imgSrc;//Çünkü resimler int değer olarak mipmap yer alır
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }
}
