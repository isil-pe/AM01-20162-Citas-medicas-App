package com.isil.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.isil.activities.model.DoctorEntity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pablo on 11/5/2016.
 */

public class DoctorBookingActivity extends Activity{
    private static final String TAG ="DoctorServiceActivity" ;
    private Button btnBook;
    private RadioGroup rgHorario;
    private RadioButton rbS1;
    private RadioButton rbS2;
    private RadioGroup rgHorario2;
    private RadioButton rbS3;
    private RadioButton rbS4;
    private CalendarView cv1;
    private TextView tvifec;
    int tipo;
    int mYear;
    int mMonth;
    int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_booking);



        btnBook= (Button)findViewById(R.id.btnBook);
       // rgHorario =(RadioGroup)findViewById(R.id.rgHorario);
        rbS1 =(RadioButton) findViewById(R.id.rbS1);
        rbS2 =(RadioButton) findViewById(R.id.rbS2);
        rbS3 =(RadioButton) findViewById(R.id.rbS3);
        rbS4 =(RadioButton) findViewById(R.id.rbS4);
        cv1 =(CalendarView) findViewById(R.id.cv1);
        tvifec=(TextView) findViewById(R.id.tvifec);

        cv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int date) {
                mDay= date;
                mYear = year;
                mMonth = month;

            }
        });

        events();

    }

    private void events(){



        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
               public void onClick(View view) {
               if (rbS1.isChecked()) {
                    tipo = 1;
                gotoResult();}
               if (rbS2.isChecked()) {
                   tipo = 2;
                   gotoResult();}
               if (rbS3.isChecked()) {
                   tipo = 3;
                   gotoResult();}

               if (rbS4.isChecked()) {
                   tipo = 4;
                   gotoResult();}

               }
            });

    }


    private void gotoDoctorDetail(DoctorEntity doctorEntity) {
        Bundle bundle= new Bundle();
        bundle.putSerializable("DATE",doctorEntity);

        Intent intent = new Intent(DoctorBookingActivity.this,
                DoctorActivity.class);
        startActivity(intent);
    }

    private void gotoResult() {
        Intent intent = new Intent(DoctorBookingActivity.this,
                DoctorActivity.class);
        intent.putExtra("tipo",tipo);
        intent.putExtra("Day",mDay);
        intent.putExtra("Month",mMonth);
        intent.putExtra("Year",mYear);
        startActivity(intent);
        finish();
    }
}
