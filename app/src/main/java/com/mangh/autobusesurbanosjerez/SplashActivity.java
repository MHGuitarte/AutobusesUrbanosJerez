package com.mangh.autobusesurbanosjerez;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 2000;

    TextView tvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvLogo = (TextView) findViewById(R.id.splash_tvLogo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //CAMBIAR FUENTE PERSONALIZADA DESDE JAVA

        /*Typeface type = Typeface.createFromAsset(getAssets(), "font/usenet.ttf");
        tvLogo.setTypeface(type); */


        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);

                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }
}