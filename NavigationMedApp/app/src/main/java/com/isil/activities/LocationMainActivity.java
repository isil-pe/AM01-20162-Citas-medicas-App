package com.isil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.GridView;

import com.isil.activities.model.LocationEntity;
import com.isil.activities.view.adapters.LocationAdapter;

import java.util.List;

/**
 * Created by Pablo on 11/27/2016.
 */

public class LocationMainActivity extends AppCompatActivity {

    private GridView gridLocation;
    private List<LocationEntity> lsLocationEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_main);
        loadData();
        app();
    }

    private void app() {
        ui();
        events();
    }

    private void ui() {
        gridLocation= (GridView)findViewById(R.id.gridLocation);
    }

    private void events() {

        gridLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                LocationEntity location= (LocationEntity) adapterView.getAdapter().getItem(position);
                gotoPlaceDetail(location);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        populate();
    }

    private void populate() {
        LocationAdapter locationAdapter= new LocationAdapter(this,lsLocationEntities );
        gridLocation.setAdapter(locationAdapter);
    }

    private void gotoPlaceDetail(LocationEntity locationEntity) {
        Bundle bundle= new Bundle();
        bundle.putSerializable("PLACE",locationEntity);

        Intent intent = new Intent(LocationMainActivity.this, LocationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void loadData() {

        DoctorApplication application= (DoctorApplication)getApplication();
        this.lsLocationEntities= application.getLocRepository().allLocations();
    }
}
