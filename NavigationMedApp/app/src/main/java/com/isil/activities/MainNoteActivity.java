package com.isil.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.isil.activities.model.NoteEntity;
import com.isil.activities.view.adapters.NoteAdapter;

import java.util.List;

public class MainNoteActivity extends Activity {

    private Button btnAddNote;
    private ListView lstNotes;
    private View tviLogout;
    private List<NoteEntity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_main);
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

    private void populate() {
        NoteAdapter noteAdapter= new NoteAdapter(this,data );
        lstNotes.setAdapter(noteAdapter);
    }

    private void loadData() {

        DoctorApplication application= (DoctorApplication)getApplication();
        data= application.getNoteRepository().allNotes();
    }

    private void ui() {
        btnAddNote= (Button)findViewById(R.id.btnAddNote);
        tviLogout= findViewById(R.id.tviLogout);
        lstNotes= (ListView)findViewById(R.id.lstNotes);
    }

    private void events() {
       /* btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote();
            }
        });*/
        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeSesion();
            }
        });
        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                NoteEntity noteEntity= (NoteEntity)adapterView.getAdapter().getItem(position);
                gotoNoteDetail(noteEntity);

            }
        });
    }

    private void gotoNoteDetail(NoteEntity noteEntity) {
        Bundle bundle= new Bundle();
        bundle.putSerializable("ENTITY",noteEntity);

        Intent intent = new Intent(MainNoteActivity.this, NoteDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    private void closeSesion() {
        Intent intent= new Intent(MainNoteActivity.this,
                DoctorServiceActivity.class);
        startActivity(intent);
        finish();
    }

   /* private void gotoNote() {
        Intent intent = new Intent(MainNoteActivity.this, AddNoteActivity.class);
        startActivity(intent);
    }*/

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        closeSesion();
    }
}
