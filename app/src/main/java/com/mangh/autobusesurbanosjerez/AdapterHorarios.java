package com.mangh.autobusesurbanosjerez;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterHorarios extends ArrayAdapter {

    Context c;
    List<String> horas;

    public AdapterHorarios(Context c,List<String> horas) {

        super(c, R.layout.item_horarios, horas);
        this.c = c;
        this.horas = horas;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_horarios, null);

        TextView tvHora = (TextView) item.findViewById(R.id.item_tvHora);
        tvHora.setText(horas.get(position).toString());

        return item;
    }
}
