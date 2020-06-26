package com.pm.miapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
        private Context context;
        private int layout;
        private List<Estacion> estaciones;

    public MyAdapter(Context context, int layout, List<Estacion> estaciones) {
        this.context = context;
        this.layout = layout;
        this.estaciones = estaciones;
    }

    @Override
    public int getCount() {
        return this.estaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return this.estaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(layout,null);
            holder=new ViewHolder();
            holder.nombre= convertView.findViewById(R.id.myTextView);
            holder.anterior= convertView.findViewById(R.id.estacionAnterior);
            holder.siguiente=convertView.findViewById(R.id.estacionSiguiente);
            holder.icono=convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }

        Estacion currentEstacion=this.estaciones.get(position);
        holder.nombre.setText(currentEstacion.getNombre());
        holder.siguiente.setText(currentEstacion.getStacionSiguiente());
        holder.anterior.setText(currentEstacion.getEstacionAnterior());
        holder.icono.setImageResource(currentEstacion.getIcono());

        return convertView;
    }

    static class ViewHolder{
        private TextView nombre;
        private TextView anterior;
        private TextView siguiente;
        private ImageView icono;
    }
}
