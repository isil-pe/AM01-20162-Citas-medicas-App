package com.isil.activities.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.activities.R;
import com.isil.activities.model.LocationEntity;

import java.util.List;

/**
 * Created by Pablo on 11/27/2016.
 */

public class LocationAdapter extends BaseAdapter {

    private Context context;
    private List<LocationEntity> lsLocationsEntities;

    public LocationAdapter(Context context, List<LocationEntity> lsLocationsEntities) {
        this.context = context;;
        this.lsLocationsEntities = lsLocationsEntities;
    }

    @Override
    public int getCount() {
        return lsLocationsEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsLocationsEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_location, null);
            ViewHolder holder = new ViewHolder();
            holder.tviLocal = (TextView) v.findViewById(R.id.tviLocal);
            holder.tviCategoria = (TextView) v.findViewById(R.id.tviCategoria);
            holder.tviDireccion = (TextView) v.findViewById(R.id.tviDireccion);
            holder.tviTelefono = (TextView) v.findViewById(R.id.tviTelefono);
            holder.tviDescripcion = (TextView) v.findViewById(R.id.tviDescripcion);
            holder.iviSede = (ImageView) v.findViewById(R.id.iviSede);
            v.setTag(holder);
        }
        LocationEntity entry = lsLocationsEntities.get(position);
        if(entry != null)
        {
            ViewHolder holder = (ViewHolder)v.getTag();
            String nombre=entry.getNombre();
            String categoria= entry.getCategoria();
            int photo = entry.getPhoto();
            String direccion=entry.getDireccion();
            String telefono=entry.getTelefono();
            String descripcion=entry.getDescripcion();


            holder.tviLocal.setText(nombre);
            holder.tviCategoria.setText(categoria);
            holder.iviSede.setImageResource(entry.getPhoto());
            holder.tviDireccion.setText(direccion);
            holder.tviTelefono.setText(telefono);
            holder.tviDescripcion.setText(descripcion);



            //holder.tviTitle.setBackgroundColor(Color.parseColor(entry.getHeaderColor()));
        }



        return v;
    }
    static class ViewHolder
    {
        ImageView iviSede;
        TextView tviLocal;
        TextView tviCategoria;
        TextView tviDireccion;
        TextView tviTelefono;
        TextView tviDescripcion;

    }
}
