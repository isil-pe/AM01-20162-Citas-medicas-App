package com.isil.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.isil.activities.model.DoctorEntity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.isil.activities.view.adapters.DoctorAdapter;


/**
 * Created by Pablo on 11/4/2016.
 */

    public class DoctorActivity extends Activity{
    private ListView lstDoctor;
    private List<DoctorEntity> data;
    private DoctorEntity doctorEntity;
    int mDay;
    int mMonth;
    int mYear;
    TextView tviCabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        tviCabe=(TextView) findViewById(R.id.tviCabe);
        extras();
        loadData();
        app();

    }
    private void app() {
        ui();
        events();
        //populate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populate();
    }

    private void extras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                doctorEntity = (DoctorEntity) bundle.getSerializable("DATE");
            }
        }
    }
    private void populate() {
        DoctorAdapter doctorAdapter= new DoctorAdapter(this,data);
        lstDoctor.setAdapter(doctorAdapter);
    }

    private void loadData() {

        Bundle datos = this.getIntent().getExtras();
        Intent intent = getIntent();
        mDay = intent.getIntExtra("Day",0);
        mMonth = intent.getIntExtra("Month",0);
        mYear = intent.getIntExtra("Year",0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(mYear,mMonth,mDay);


        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        tviCabe.setText("Cita:"+(format.format(calendar.getTime())));
        int tipo = datos.getInt("tipo");
        if(tipo ==1) {

            DoctorApplication application = (DoctorApplication) getApplication();
            //data = application.getDoctorRepository().allDoctor();
            this.data=application.getDoctor2Repository().getDoctorByCategory(tipo);
        }
        if(tipo ==2) {

            DoctorApplication application = (DoctorApplication) getApplication();
            //data = application.getDoctorRepository().allDoctor();
            this.data=application.getDoctor2Repository().getDoctorByCategory(tipo);
        }

        if(tipo ==3) {

            DoctorApplication application = (DoctorApplication) getApplication();
            //data = application.getDoctorRepository().allDoctor();
            this.data=application.getDoctor2Repository().getDoctorByCategory(tipo);
        }
        if(tipo ==4) {

            DoctorApplication application = (DoctorApplication) getApplication();
            //data = application.getDoctorRepository().allDoctor();
            this.data=application.getDoctor2Repository().getDoctorByCategory(tipo);
        }
    }

    private void ui() {

        lstDoctor= (ListView)findViewById(R.id.lstDoctor);
    }

    private void events() {

        lstDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Toast.makeText(DoctorActivity.this, "Cita Programada. Revise su email",
                        Toast.LENGTH_SHORT).show();
                //DoctorEntity doctorEntity= (DoctorEntity)adapterView.getAdapter().getItem(position);
                //gotoDoctorDetail(doctorEntity);

            }
        });
    }
    /*private void gotoDoctorDetail(DoctorEntity doctorEntity) {
        Bundle bundle= new Bundle();
        bundle.putSerializable("ENTITY",doctorEntity);


    }*/
}
