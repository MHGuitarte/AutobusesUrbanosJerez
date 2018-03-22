package com.mangh.autobusesurbanosjerez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void accLineas (View view) {

        Intent i =new Intent(getApplicationContext(), ActivityLineas.class);
        startActivity(i);

    }

    public void accParadas (View view) {

        Intent i = new Intent(getApplicationContext(), ActivityRecorridos.class);
        startActivity(i);

    }

    public void accInfo (View view) {

        String url = "http://www.jerez.es/webs_municipales/autobuses_urbanos/noticias/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void accAbout (View view) {



    }


}
