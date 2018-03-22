package com.mangh.autobusesurbanosjerez;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLinea extends ArrayAdapter {

    ArrayList<CLinea> lineas = new ArrayList<CLinea>();
    Context c;

    public AdapterLinea(Context c, ArrayList<CLinea> lineas) {

        super(c, R.layout.item_linea, lineas);
        this.c = c;
        this.lineas = lineas;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_linea, null);

        TextView tvLinea = (TextView) item.findViewById(R.id.item_tvLinea);
        tvLinea.setText(lineas.get(position).getLinea());


        if (lineas.get(position).getLinea().equals("Linea 1")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea1);

        } else if (lineas.get(position).getLinea().equals("Linea 2")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea2);

        } else if (lineas.get(position).getLinea().equals("Linea 3")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea3);

        } else if (lineas.get(position).getLinea().equals("Linea 4")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea4);

        } else if (lineas.get(position).getLinea().equals("Linea 5")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea5);

        } else if (lineas.get(position).getLinea().equals("Linea 6")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea6);

        } else if (lineas.get(position).getLinea().equals("Linea 7")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea7);

        } else if (lineas.get(position).getLinea().equals("Linea 8")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea8);

        } else if (lineas.get(position).getLinea().equals("Linea 9")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea9);

        } else if (lineas.get(position).getLinea().equals("Linea 10")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea10);

        } else if (lineas.get(position).getLinea().equals("Linea 11")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea11);

        } else if (lineas.get(position).getLinea().equals("Linea 12")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea12);

        } else if (lineas.get(position).getLinea().equals("Linea 13")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea13);

        } else if (lineas.get(position).getLinea().equals("Linea 14")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea14);

        } else if (lineas.get(position).getLinea().equals("Linea 15")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea15);

        } else if (lineas.get(position).getLinea().equals("Linea 16")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea16);

        } else if (lineas.get(position).getLinea().equals("Linea 17")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea17);

        } else if (lineas.get(position).getLinea().equals("Linea 18")) {

            ImageView ivLinea = (ImageView) item.findViewById(R.id.item_ivLinea);
            ivLinea.setImageResource(R.drawable.linea18);

        }

        return item;
    }

}
