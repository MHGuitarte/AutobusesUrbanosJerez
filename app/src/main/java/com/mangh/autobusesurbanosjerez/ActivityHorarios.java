package com.mangh.autobusesurbanosjerez;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ActivityHorarios extends AppCompatActivity {

    //Declaración de variables

    static final String EXTRA_PARADA_FROM_HORA = "PARADA";
    static final String EXTRA_LINEA_FROM_HORA = "LINEA";

    ListView lvLaborable, lvSabado, lvDomingo;
    DatabaseReference dbRef;

    String linea = "";
    String parada = "";

    TabHost tabs;
    int index = 0;

    FloatingActionButton btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);

        //Identificación de recursos

        lvLaborable = (ListView) findViewById(R.id.hor_lvLaborable);
        lvSabado = (ListView) findViewById(R.id.hor_lvSabado);
        lvDomingo = (ListView) findViewById(R.id.hor_lvDomingo);

        btnLeft = (FloatingActionButton) findViewById(R.id.btnLeft);
        btnRight = (FloatingActionButton) findViewById(R.id.btnRight);


        Bundle b = getIntent().getExtras();

        if (b != null) {

            linea = b.getString(ActivityParadas.EXTRA_LINEA_FROM_PARADA);
            parada = b.getString(ActivityParadas.EXTRA_PARADA);

            //Acceso a la base de datos

            dbRef = FirebaseDatabase.getInstance().getReference().child("lineas/" + linea + "/" + parada);

            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    CParada p = dataSnapshot.getValue(CParada.class);

                    adaptarString(p.getLaborables(), lvLaborable);
                    adaptarString(p.getSabados(), lvSabado);
                    adaptarString(p.getDomingos(), lvDomingo);

                    setTitle(p.getNombre().toString());


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        //Identificación de tabs

        Resources res = getResources();

        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("laborables");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Laborables");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("sabados");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Sábados");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("domingos");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Domingos y festivos");
        tabs.addTab(spec);


        tabs.setCurrentTab(index);

        //Acciones de botones flotantes

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index > 0) {

                    index--;

                    tabs.setCurrentTab(index);

                }

            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index <= 3) {

                    index++;

                    tabs.setCurrentTab(index);

                }

            }
        });


    }

    //Métodos extra

    private void adaptarString(List<String> list, ListView listView) {

        AdapterHorarios adapter = new AdapterHorarios(this, list);
        listView.setAdapter(adapter);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(getApplicationContext(), ActivityParadas.class);
        i.putExtra(EXTRA_PARADA_FROM_HORA, parada);
        i.putExtra(EXTRA_LINEA_FROM_HORA, linea);
        finish();
        startActivity(i);


    }

}
