package com.isil.activities.storage;

import com.isil.activities.R;
import com.isil.activities.model.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Profesor on 03/11/2016.
 */
public class NoteRepository {

    private List<NoteEntity> lsNoteEntities;

    public NoteRepository() {
        lsNoteEntities= new ArrayList<NoteEntity>();
    }

    public void mock() {

        Calendar calendar= Calendar.getInstance();
        String ndate= ""+calendar.getTime();

        NoteEntity noteEntity= new NoteEntity(1,"Referencia","Mis comentarios",ndate,"Dr. Raul Gonzales","Cardiologia");
        noteEntity.setIcon(R.drawable.doc1);
        NoteEntity noteEntity1= new NoteEntity(2,"Referencia","Mis comentarios",ndate,"Dra. Carla Doig","Traumatologia");
        noteEntity1.setIcon(R.drawable.doc2);
        NoteEntity noteEntity2= new NoteEntity(3,"Referencia","Mis comentarios",ndate,"Dr. Carlos Garcia","Oftalmologia");
        noteEntity2.setIcon(R.drawable.doc3);
        NoteEntity noteEntity3= new NoteEntity(4,"Referencia","Mis comentarios",ndate,"Dr. Ruben Razo","Endocrinologia");
        noteEntity3.setIcon(R.drawable.doc4);
        NoteEntity noteEntity4= new NoteEntity(5,"Referencia","Mis comentarios",ndate,"Dr. Fernando Wong","Cardiologia");
        noteEntity4.setIcon(R.drawable.doc5);
        NoteEntity noteEntity5= new NoteEntity(6,"Referencia","Mis comentarios",ndate,"Dr. Roberto Cruz","Dermatologia");
        noteEntity5.setIcon(R.drawable.doc6);
        NoteEntity noteEntity6= new NoteEntity(7,"Referencia","Mis comentarios",ndate,"Dr. Enrique Peña","Traumatologia");
        noteEntity6.setIcon(R.drawable.doc7);
        NoteEntity noteEntity7= new NoteEntity(8,"Referencia","Mis comentarios",ndate,"Dr. Jose Zegarra","Cardiologia");
        noteEntity7.setIcon(R.drawable.doc8);
        NoteEntity noteEntity8= new NoteEntity(9,"Referencia","Mis comentarios",ndate,"Eduardo Leon","Oftalmologia");
        noteEntity8.setIcon(R.drawable.doc9);
        NoteEntity noteEntity9= new NoteEntity(10,"Referencia","Mis comentarios",ndate,"Dr. Ricardo Lara","Dermatologia");
        noteEntity9.setIcon(R.drawable.doc10);
        NoteEntity noteEntity10= new NoteEntity(11,"Referencia","Mis comentarios",ndate,"Dra. Rita Gomez","Endocrinologia");
        noteEntity10.setIcon(R.drawable.doc11);
        NoteEntity noteEntity11= new NoteEntity(12,"Referencia","Mis comentarios",ndate,"Dr. Jesus Fernandez","Traumatologia");
        noteEntity11.setIcon(R.drawable.doc12);

        lsNoteEntities.add(noteEntity);
        lsNoteEntities.add(noteEntity1);
        lsNoteEntities.add(noteEntity2);
        lsNoteEntities.add(noteEntity3);
        lsNoteEntities.add(noteEntity4);
        lsNoteEntities.add(noteEntity5);
        lsNoteEntities.add(noteEntity6);
        lsNoteEntities.add(noteEntity7);
        lsNoteEntities.add(noteEntity8);
        lsNoteEntities.add(noteEntity9);
        lsNoteEntities.add(noteEntity10);
        lsNoteEntities.add(noteEntity11);


    }

    public void addNote(NoteEntity noteEntity)
    {
        lsNoteEntities.add(noteEntity);
    }

    public void removeNote(NoteEntity noteEntity)
    {
        this.lsNoteEntities.remove(noteEntity);
    }

    public void removeNoteById(int noteId)
    {
        int position=-1;
        NoteEntity note;
        for (int i = 0; i <this.lsNoteEntities.size() ; i++)
        {
            note= lsNoteEntities.get(i);
            if(note.getId()==noteId)
            {
                position=i;
                break;
            }
        }
        if(position>=0 && position<lsNoteEntities.size())
        {
            this.lsNoteEntities.remove(position);
        }
    }

    public void updateNote(int position, NoteEntity noteEntity)
    {
        if(position<lsNoteEntities.size())
        {
            lsNoteEntities.set(position, noteEntity);
        }
    }
    public void updateNoteById(int noteId, NoteEntity noteEntity)
    {
        int position=-1;
        NoteEntity note;
        for (int i = 0; i <this.lsNoteEntities.size() ; i++) {
            note= lsNoteEntities.get(i);
            if(note.getId()==noteId)
            {
                position=i;
                break;
            }
        }
        if(position>=0 && position<lsNoteEntities.size())
        {
            this.lsNoteEntities.set(position, noteEntity);
        }
    }


    public List<NoteEntity> allNotes()
    {
        return this.lsNoteEntities;
    }

    public int countNotes()
    {
        return this.lsNoteEntities.size();
    }
    public NoteEntity lastNote()
    {
        if(this.lsNoteEntities.size()>0)
        {
            return this.lsNoteEntities.get(this.lsNoteEntities.size()-1);
        }
        return null;
    }
}
