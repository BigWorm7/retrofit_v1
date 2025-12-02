package com.pt2.fd;

import com.google.gson.annotations.SerializedName;

public class Pytania {
    @SerializedName("tresc")
    private String trescpytania;

    private String odpa;
    private String odpb;
    private String odpc;
    private int poprawna;

    public Pytania(String trescpytania, String odpa, String odpb, String odpc, int poprawna) {
        this.trescpytania = trescpytania;
        this.odpa = odpa;
        this.odpb = odpb;
        this.odpc = odpc;
        this.poprawna = poprawna;
    }

    public String getTrescpytania() {
        return trescpytania;
    }

    public void setTrescpytania(String trescpytania) {
        this.trescpytania = trescpytania;
    }

    public String getOdpa() {
        return odpa;
    }

    public void setOdpa(String odpa) {
        this.odpa = odpa;
    }

    public String getOdpb() {
        return odpb;
    }

    public void setOdpb(String odpb) {
        this.odpb = odpb;
    }

    public String getOdpc() {
        return odpc;
    }

    public void setOdpc(String odpc) {
        this.odpc = odpc;
    }

    public int getPoprawna() {
        return poprawna;
    }

    public void setPoprawna(int poprawna) {
        this.poprawna = poprawna;
    }
//private int udzielonaOdpowiedz;
    //private boolean czyUdzielonoPoprawnejOdpowiedzil;

}
