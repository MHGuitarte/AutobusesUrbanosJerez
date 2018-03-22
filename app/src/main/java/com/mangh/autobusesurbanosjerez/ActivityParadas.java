package com.mangh.autobusesurbanosjerez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityParadas extends AppCompatActivity {

    static final String EXTRA_PARADA = "PARADA";
    static final String EXTRA_LINEA_FROM_PARADA = "LINEA";

    ListView lvParadas;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    String[] listaParadas;
    String linea = "";
    String parada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paradas);

        lvParadas = (ListView) findViewById(R.id.par_lvParadas);

        Bundle b = getIntent().getExtras();

        if (b != null) {

            linea = b.getString(ActivityLineas.EXTRA_LINEA);

            dbRef = FirebaseDatabase.getInstance().getReference().child("lineas/" + linea + "/paradas");


            valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String l = dataSnapshot.getValue().toString();

                    String[] paradas = formatearArray(l);

                    adaptarString(paradas, lvParadas);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Toast.makeText(getApplicationContext(), "Error de red. Inténtelo de nuevo.", Toast.LENGTH_SHORT).show();

                }
            };

            dbRef.addListenerForSingleValueEvent(valueEventListener);

        }
        lvParadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parada = ((String) parent.getItemAtPosition(position));
                Intent i = new Intent(getApplicationContext(), ActivityHorarios.class);
                parada = parada.trim();
                i.putExtra(EXTRA_PARADA, parada);
                i.putExtra(EXTRA_LINEA_FROM_PARADA, linea);
                finish();
                startActivity(i);





            }
        });

        setTitle(linea);


    }

    private String[] formatearArray(String array) {
        String[] array_string = array.split(",");

        for (int i = 0; i < array_string.length; i++) {
            array_string[i] = array_string[i].replace("[", "");
            array_string[i] = array_string[i].replace("]", "");
        }

        return array_string;
    }

    private void adaptarString(String[] strings, ListView listView) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(getApplicationContext(), ActivityLineas.class);
        i.putExtra(EXTRA_PARADA, parada);
        i.putExtra(EXTRA_LINEA_FROM_PARADA, linea);
        finish();
        startActivity(i);


    }


}
