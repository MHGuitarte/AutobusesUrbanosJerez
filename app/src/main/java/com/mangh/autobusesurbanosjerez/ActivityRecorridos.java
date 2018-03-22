package com.mangh.autobusesurbanosjerez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityRecorridos extends AppCompatActivity {

    ListView lvLineas;

    ArrayList<CLinea> listaLineas = new ArrayList<CLinea>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorridos);


        cargarLineas();

        lvLineas = (ListView) findViewById(R.id.re_lvLineas);
        lvLineas.setAdapter(new AdapterLinea(this, listaLineas));

        //Al clicar en un elemento de la lista, abre el navegador y carga el mapa concreto

        lvLineas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Clase Mapa con un String de la línea y un String con la url a cargar

                CLinea linea = ((CLinea) parent.getItemAtPosition(position));

                String lineaMap = linea.getUrlLinea();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(lineaMap));
                startActivity(i);

            }
        });

        setTitle("Selecciona una línea");

    }

    private void cargarLineas() {

        listaLineas.add(new CLinea("Linea 1", "https://www.google.com/maps/d/embed?mid=1E3zV0fodHah3VNlpx-tTQHNM89M&hl=es"));
        listaLineas.add(new CLinea("Linea 2", "https://www.google.com/maps/d/embed?mid=1ihPZziTYf4u9yjUdXAeFdBfgdxw&hl=es"));
        listaLineas.add(new CLinea("Linea 3", "https://www.google.com/maps/d/embed?mid=1lXODnh_KmLhhre9CC5efggDkdKc&hl=es"));
        listaLineas.add(new CLinea("Linea 4", "https://www.google.com/maps/d/embed?mid=1Dey3mf9mGj-7Oub_bIqQdPgEkAo&hl=es"));
        listaLineas.add(new CLinea("Linea 5", "https://www.google.com/maps/d/embed?mid=1YAJnXFmR0GKm3s8XLmkbcYkqf-g&hl=es"));
        listaLineas.add(new CLinea("Linea 6", "https://www.google.com/maps/d/embed?mid=1XU3ameOjn6w9ApJYS__Dej6dV0s&hl=es"));
        listaLineas.add(new CLinea("Linea 7", "https://www.google.com/maps/d/embed?mid=14l8AfnbCAqf1AZsE6VjMUyxpGbw&hl=es"));
        listaLineas.add(new CLinea("Linea 8", "https://www.google.com/maps/d/embed?mid=1o0_5G23oSVNGTIxKJzDoytou6go&hl=es"));
        listaLineas.add(new CLinea("Linea 9", "https://www.google.com/maps/d/embed?mid=1ZLkcKGReox3XygKLaptwjejIcMg&hl=es"));
        listaLineas.add(new CLinea("Linea 10", "https://www.google.com/maps/d/embed?mid=1KAyfWlNxoUJcuxJpHxvzulkiYRI&hl=es"));
        listaLineas.add(new CLinea("Linea 11", "https://www.google.com/maps/d/embed?mid=1bos6u1cGIAdZePfA9zcWchgWcFc&hl=es"));
        listaLineas.add(new CLinea("Linea 12", "https://www.google.com/maps/d/embed?mid=14JUywBRLq9ZgYECrMvSUKS0tqu0&hl=es"));
        listaLineas.add(new CLinea("Linea 13", "https://www.google.com/maps/d/embed?mid=1O7q7Iw7Kzdy5zJgQ0d9N6ASYgs0&hl=es"));
        listaLineas.add(new CLinea("Linea 14", "https://www.google.com/maps/d/embed?mid=1CYyhOkc6F6o9hidxySDJjuGPb58&hl=es"));
        listaLineas.add(new CLinea("Linea 15", "https://www.google.com/maps/d/embed?mid=1L1h_LbQHUKRlzYc-YkYkuhiLaU8"));
        listaLineas.add(new CLinea("Linea 16", "https://www.google.com/maps/d/embed?mid=1VoIwbdm7zvTdlAPdPhcfs10J7NY&hl=es"));
        listaLineas.add(new CLinea("Linea 17", "https://www.google.com/maps/d/embed?mid=1Kd4L2xVax_MikcicqGjqpFcae1U&hl=es"));
        listaLineas.add(new CLinea("Linea 18", "https://www.google.com/maps/d/embed?mid=1otJT8tZEBVjiZPIWd5TuHH9M2Fo&hl=es"));

    }

}
