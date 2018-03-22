package com.mangh.autobusesurbanosjerez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityLineas extends AppCompatActivity {

    static final String EXTRA_LINEA = "LINEA";

    ListView lvLineas;

    ArrayList<CLinea> listaLineas = new ArrayList<CLinea>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineas);

        cargarLineas();

        lvLineas = (ListView) findViewById(R.id.lin_lvLineas);
        lvLineas.setAdapter(new AdapterLinea(this, listaLineas));

        lvLineas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CLinea linea = ((CLinea) parent.getItemAtPosition(position));

                String nombre = linea.getLinea().toString();

                Intent i = new Intent(getApplicationContext(), ActivityParadas.class);
                i.putExtra(EXTRA_LINEA, nombre);
                finish();
                startActivity(i);

            }
        });

        setTitle("Selecciona una línea");

    }

    private void cargarLineas() {

        listaLineas.add(new CLinea("Linea 1", ""));
        listaLineas.add(new CLinea("Linea 2", ""));
        listaLineas.add(new CLinea("Linea 3", ""));
        listaLineas.add(new CLinea("Linea 4", ""));
        listaLineas.add(new CLinea("Linea 5", ""));
        listaLineas.add(new CLinea("Linea 6", ""));
        listaLineas.add(new CLinea("Linea 7", ""));
        listaLineas.add(new CLinea("Linea 8", ""));
        listaLineas.add(new CLinea("Linea 9", ""));
        listaLineas.add(new CLinea("Linea 10", ""));
        listaLineas.add(new CLinea("Linea 11", ""));
        listaLineas.add(new CLinea("Linea 12", ""));
        listaLineas.add(new CLinea("Linea 13", ""));
        listaLineas.add(new CLinea("Linea 14", ""));
        listaLineas.add(new CLinea("Linea 15", ""));
        listaLineas.add(new CLinea("Linea 16", ""));
        listaLineas.add(new CLinea("Linea 17", ""));
        listaLineas.add(new CLinea("Linea 18", ""));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(i);

    }
}
