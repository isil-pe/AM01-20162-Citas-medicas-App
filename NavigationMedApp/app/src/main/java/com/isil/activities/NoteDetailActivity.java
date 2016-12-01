package com.isil.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.isil.activities.model.NoteEntity;


public class NoteDetailActivity extends Activity {

    private Button btnUpdate;
    private Button btnDelete;
    private EditText eteName;
    private EditText eteDesc;
    private EditText eteNote;
    private TextView tviDoctor;
    private TextView tviEspec;

    private String name,desc,doctor,espec;
    private NoteEntity noteEntity;
    private DoctorApplication noteApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_comment);
        extras();
        app();
    }

    private void app() {
        ui();
        //pintar
        if(noteEntity!=null)
        {
            eteName.setText(noteEntity.getName());
            eteDesc.setText(noteEntity.getDescription());
            tviDoctor.setText(noteEntity.getDoctor());
            tviEspec.setText(noteEntity.getEspec());
        }
        noteApplication= (DoctorApplication)(getApplication());
        //events
        /*btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote();
                gotoMain();
            }
        });*/
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
                gotoMain();
            }
        });

    }

    private void updateNote()
    {
        name= eteName.getText().toString().trim();
        desc= eteDesc.getText().toString().trim();
        doctor= noteEntity.getDoctor();
        espec = noteEntity.getEspec();
        int icon = noteEntity.getIcon();



        NoteEntity note= new NoteEntity(noteEntity.getId(),name,desc,doctor,espec);
        note.setIcon(icon);
        noteApplication.getNoteRepository().updateNoteById(noteEntity.getId(), note);
    }

    /*private void deleteNote()
    {
        int noteId= noteEntity.getId();
        noteApplication.getNoteRepository().removeNoteById(noteId);
    }*/

    private void ui() {
        btnUpdate= (Button)findViewById(R.id.btnUpdate);
        btnDelete= (Button)findViewById(R.id.btnDelete);
        eteName= (EditText)findViewById(R.id.eteName);
        eteDesc= (EditText)findViewById(R.id.eteDesc);
        eteNote= (EditText)findViewById(R.id.eteNote);
        tviDoctor= (TextView) findViewById(R.id.tviDoctor);
        tviEspec= (TextView) findViewById(R.id.tviEspec);
    }

    private void extras()
    {
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            noteEntity = (NoteEntity)bundle.getSerializable("ENTITY");
        }
    }

    private void gotoMain() {
        finish();
    }

}
