package net.javatutorial.tutorials;

import java.util.HashMap;
import java.util.Map;

public class URLObjesi {
    private String url;
    private double puan;
    private HashMap<String, Integer> kelimeBazliPuanlari = new HashMap<>();
    private HashMap<Enum, Integer> esanlamliKelimelerlePuanlari = new HashMap<>();
    private int derinlik;

    public URLObjesi(String url, HashMap<String, Integer> kelimeBazliPuanlari) {
        this.derinlik = 1;
        this.url = url;
        this.kelimeBazliPuanlari = kelimeBazliPuanlari;
    }

    public URLObjesi(String url, HashMap<Enum, Integer> esanlamliKelimelerlePuanlari, boolean esAnlamlilar) {
        this.url = url;
        this.esanlamliKelimelerlePuanlari = esanlamliKelimelerlePuanlari;
        this.derinlik = 1;
    }

    public URLObjesi(String url, HashMap<String, Integer> kelimeBazliPuanlari, int derinlik) {
        this.url = url;
        this.kelimeBazliPuanlari = kelimeBazliPuanlari;
        this.derinlik = derinlik;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPuan() {
        return puan;
    }

    public void setPuan(double puan) {
        this.puan = puan;
    }

    public HashMap<String, Integer> getKelimeBazliPuanlari() {
        return kelimeBazliPuanlari;
    }

    public void setKelimeBazliPuanlari(HashMap<String, Integer> kelimeBazliPuanlari) {
        this.kelimeBazliPuanlari = kelimeBazliPuanlari;
    }

    public void puaniniHesapla() {
        this.puan = 1;
        for (Integer puan : kelimeBazliPuanlari.values()) {
            this.puan *= puan;
        }
        this.puan = (double) 1 / this.puan;
    }

    public void puaniniSiralamayaGoreHesapla() {
        this.puan = 1;
        for (Integer puan : kelimeBazliPuanlari.values()) {
            this.puan += (puan * derinlik);
        }
    }

    public String yazdirilacakHali(){
        String s= url;

        s += " puan: "+this.puan +" [ ";

        for (Map.Entry<String, Integer> stringIntegerEntry : kelimeBazliPuanlari.entrySet()) {
            s+= stringIntegerEntry.getKey()+": "+stringIntegerEntry.getValue()+"\t";
        }
        s+= "]";
        return s;
    }
}
