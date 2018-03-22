package com.mangh.autobusesurbanosjerez;

import android.net.Uri;

/**
 * Created by mangh on 08/03/2018.
 */

public class CMaps {

    String nombreMap;
    Uri url;

    public CMaps(String nombreMap, Uri url) {
        this.nombreMap = nombreMap;
        this.url = url;
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public String getNombreMap() {
        return nombreMap;
    }

    public void setNombreMap(String nombreMap) {
        this.nombreMap = nombreMap;
    }
}
