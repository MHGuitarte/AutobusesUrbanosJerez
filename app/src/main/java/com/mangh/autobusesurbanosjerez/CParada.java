package com.mangh.autobusesurbanosjerez;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class CParada implements Parcelable {

    String nombre;
    List<String> laborables;
    List<String> sabados;
    List<String> domingos;
     

    public CParada(String nombre, List<String> laborables, List<String> sabados, List<String> domingos) {
        this.nombre = nombre;
        this.laborables = laborables;
        this.sabados = sabados;
        this.domingos = domingos;
    }

    public CParada() {
    }

    protected CParada(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<CParada> CREATOR = new Creator<CParada>() {
        @Override
        public CParada createFromParcel(Parcel in) {
            return new CParada(in);
        }

        @Override
        public CParada[] newArray(int size) {
            return new CParada[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getLaborables() {
        return laborables;
    }

    public void setLaborables(List<String> laborables) {
        this.laborables = laborables;
    }

    public List<String> getSabados() {
        return sabados;
    }

    public void setSabados(List<String> sabados) {
        this.sabados = sabados;
    }

    public List<String> getDomingos() {
        return domingos;
    }

    public void setDomingos(List<String> domingos) {
        this.domingos = domingos;
    }

    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        p.readList(this.laborables,null);
        p.readList(this.sabados,null);
        p.readList(this.domingos,null);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
       dest.writeList(this.laborables);
       dest.writeList(this.sabados);
       dest.writeList(this.domingos);

    }
}
