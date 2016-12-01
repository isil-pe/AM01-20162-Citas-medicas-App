package com.isil.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pablo on 11/5/2016.
 */

public class DoctorLoginActivity extends Activity{
    /*private static final String TAG ="DoctorLoginActivity" ;
    private Button btnLogin;
    private Button btnRegister;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        ui();
    }

    private void ui() {
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoService();
            }
        });

        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRegister();
            }
        });
    }

    /*btnLogin= (Button)findViewById(R.id.btnLogin);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoService();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRegister();
            }
        });


    protected void onCreate2(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);


        btnRegister = (Button)findViewById(R.id.btnRegister);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRegister();
            }
        });
    }*/

    /*private void gotoService() {
        Intent intent = new Intent(DoctorLoginActivity.this,
                DoctorServiceActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoRegister() {
        Intent intent = new Intent(DoctorLoginActivity.this,
                DoctorSignUpActivity.class);
        startActivity(intent);
        finish();
    }*/
    private void gotoService() {
        startActivity(new Intent(this,DoctorServiceActivity.class));
    }
    private void gotoRegister() {
        startActivity(new Intent(this,DoctorSignUpActivity.class));
    }
}
