package com.isil.activities;

import android.app.Activity;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Pablo on 11/5/2016.
 */

public class DoctorSignUpActivity extends Activity {

    private TextView txtfecnac;
    private EditText etDocument,etName,etLastName1,etLastName2,etEmail,etPhone;
    private RadioGroup rgTipoDocument;
    private Button btnSignUp;
    private int idNro=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_signup);
        app();
    }
    private void app() {
        // TODO Auto-generated method stub
        txtfecnac =(TextView)findViewById(R.id.lblfecnac);
        etDocument =(EditText)findViewById(R.id.etDocument);
        etName =(EditText)findViewById(R.id.etName);
        etLastName1 =(EditText)findViewById(R.id.etLastName1);
        etLastName2 =(EditText)findViewById(R.id.etLastName2);
        etEmail =(EditText)findViewById(R.id.etEmail);
        etPhone =(EditText)findViewById(R.id.etPhone);
        rgTipoDocument =(RadioGroup)findViewById(R.id.rgTipoDocument);

        btnSignUp =(Button)findViewById(R.id.btnSignUp);

        txtfecnac.setTag(null);
        events();
    }

    private void events() {
        // TODO Auto-generated method stub
        txtfecnac.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(100);
            }
        });
        btnSignUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFormError())
                {
                    Toast.makeText(DoctorSignUpActivity.this, "Enviando al servidor...",
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(DoctorSignUpActivity.this, "Revisar campos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        rgTipoDocument.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rbN:
                        idNro = 1;
                        break;
                    case R.id.rbE:
                        idNro = 2;
                        break;
                }
            }
        });


    }

    private boolean validateForm()
    {
        String document= etDocument.getText().toString().trim();
        String name= etName.getText().toString().trim();
        String lastName1= etLastName1.getText().toString().trim();
        String lastName2= etLastName2.getText().toString().trim();
        String email= etEmail.getText().toString().trim();
        String phone= etPhone.getText().toString().trim();


        //genero
        Log.v("CONSOLE", "genero " + idNro);
        if(idNro==0)return false;

        if(document.isEmpty())return false;
        if(name.isEmpty())return false;
        if(lastName1.isEmpty())return false;
        if(lastName2.isEmpty())return false;
        if(email.isEmpty())return false;
        if(phone.isEmpty())return false;

        //fecha nacimiento
        Object fnac= txtfecnac.getTag();
        if(fnac==null) return false;

        return true;
    }

    private boolean validateFormError()
    {
        String document= etDocument.getText().toString().trim();
        String name= etName.getText().toString().trim();
        String lastName1= etLastName1.getText().toString().trim();
        String lastName2= etLastName2.getText().toString().trim();
        String email= etEmail.getText().toString().trim();
        String phone= etPhone.getText().toString().trim();



        Log.v("CONSOLE", "genero " + idNro);
        if(idNro==0){
            Toast.makeText(DoctorSignUpActivity.this, "Seleccionar Documento",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        if(document.isEmpty())
        {
            etDocument.setError("Campo incompleto");
            return false;
        }

        if(name.isEmpty())
        {
            etName.setError("Campo incompleto");
            return false;
        }
        if(lastName1.isEmpty())
        {
            etLastName1.setError("Campo incompleto");
            return false;
        }
        if(lastName2.isEmpty())
        {
            etLastName2.setError("Campo incompleto");
            return false;
        }
        //fecha nacimiento
        Object fnac= txtfecnac.getTag();
        if(fnac==null) {
            Toast.makeText(DoctorSignUpActivity.this, "Seleccionar Fecha",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        if(phone.isEmpty())
        {
            etPhone.setError("Campo incompleto");
            return false;
        }

        if(email.isEmpty()){
            etEmail.setError("Campo incompleto");
            return false;
        }


        if(!isEmailValid(email)){
            etEmail.setError("E-mail inválido");
            return false;
        }


        return true;
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        switch (id) {
            case 100:
                final Calendar c=Calendar.getInstance();
                c.add(Calendar.YEAR,1);
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);

                return new DatePickerDialog(this, new OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        String s= dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                        Log.v("CONSOLE", "s "+s);
                        txtfecnac.setText(s);
                        txtfecnac.setTag(1);


                    }
                }, year, month, day);

            default:
                break;
        }
        return null;
    }
}
