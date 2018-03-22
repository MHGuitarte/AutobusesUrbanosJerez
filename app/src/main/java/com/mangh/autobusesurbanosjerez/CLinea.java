package com.mangh.autobusesurbanosjerez;


import android.os.Parcel;
import android.os.Parcelable;

public class CLinea implements Parcelable {

    String linea;
    String urlLinea;

    public CLinea(String linea, String urlLinea) {
        this.linea = linea;
        this.urlLinea = urlLinea;
    }

    public CLinea() {
    }

    protected CLinea(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<CLinea> CREATOR = new Creator<CLinea>() {
        @Override
        public CLinea createFromParcel(Parcel in) {
            return new CLinea(in);
        }

        @Override
        public CLinea[] newArray(int size) {
            return new CLinea[size];
        }
    };

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getUrlLinea() {
        return urlLinea;
    }

    public void setUrlLinea(String urlLinea) {
        this.urlLinea = urlLinea;
    }

    private void readFromParcel(Parcel p) {

        this.linea = p.readString();
        this.urlLinea = p.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.linea);
        dest.writeString(this.urlLinea);

    }
}
