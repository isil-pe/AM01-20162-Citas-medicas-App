package com.isil.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.isil.activities.model.DoctorEntity;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Pablo on 11/5/2016.
 */

public class DoctorSplashActivity extends Activity{
    private static final long SPLASH_SCREEN_DELAY = 4000;//4segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask()
        {
            @Override
            public void run() {

                //Actividad inicial, Siguiente Actividad
                Intent intent = new Intent(DoctorSplashActivity.this,
                        DoctorLoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private void extras(){
        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            DoctorEntity doctorEntity= (DoctorEntity) bundle.getSerializable("ENTITY");
        }
    }
}
