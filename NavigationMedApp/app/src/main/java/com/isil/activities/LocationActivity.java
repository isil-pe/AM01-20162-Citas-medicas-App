package com.isil.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.activities.model.LocationEntity;

/**
 * Created by Pablo on 11/27/2016.
 */

public class LocationActivity extends AppCompatActivity {

    private ImageView iviSede;
    private TextView tviLocal;
    private TextView tviCategoria;
    private TextView tviDireccion;
    private TextView tviTelefono;
    private TextView tviDescripcion;
    private LocationEntity locationEntities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sedes);
        extras();
        ui();
        populate();
    }

    private void extras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                locationEntities = (LocationEntity) bundle.getSerializable("PLACE");
            }
        }
    }

    private void ui() {
        //iviStar1= (ImageView)findViewById(R.id.iviStar1);
        tviLocal= (TextView) findViewById(R.id.tviTitle);
        tviCategoria= (TextView) findViewById(R.id.tviCat);
        tviDireccion= (TextView) findViewById(R.id.tviDir);
        tviTelefono= (TextView) findViewById(R.id.tviTel);
        tviDescripcion= (TextView) findViewById(R.id.tviDes);
    }

    private void populate() {
        if(locationEntities==null)return;


        tviLocal.setText(locationEntities.getNombre());
        tviCategoria.setText(locationEntities.getCategoria());
        //iviPlace.setImageResource(restaurantes.getPhoto());
        tviDireccion.setText(locationEntities.getDireccion());
        tviTelefono.setText(locationEntities.getTelefono());
        tviDescripcion.setText(locationEntities.getDescripcion());

    }
}
