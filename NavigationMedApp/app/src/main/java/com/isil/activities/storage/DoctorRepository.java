package com.isil.activities.storage;

import com.isil.activities.model.DoctorEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import com.isil.activities.R;

/**
 * Created by Pablo on 11/4/2016.
 */

public class DoctorRepository {

    private List<DoctorEntity> lsDoctorEntities;

    public DoctorRepository(){lsDoctorEntities= new ArrayList<DoctorEntity>();}

    public void mock() {


        DoctorEntity doctorEntity= new DoctorEntity(1,"Dr. Raul Gonzales","Cardiologia","Sede Miraflores",true,1);
        doctorEntity.setIcon(R.drawable.doc1);
        DoctorEntity doctorEntity1= new DoctorEntity(2,"Dra. Carla Doig","Traumatologia","Sede Jesus Maria",true,2);
        doctorEntity1.setIcon(R.drawable.doc2);
        DoctorEntity doctorEntity2= new DoctorEntity(3,"Dr. Carlos Garcia","Oftalmologia","Sede Miraflores",true,3);
        doctorEntity2.setIcon(R.drawable.doc3);
        DoctorEntity doctorEntity4= new DoctorEntity(4,"Dr. Ruben Razo","Endocrinologia","Sede La Molina",true,1);
        doctorEntity4.setIcon(R.drawable.doc4);
        DoctorEntity doctorEntity5= new DoctorEntity(5,"Dr. Fernando Wong","Cardiologia","Sede Jesus Maria",true,1);
        doctorEntity5.setIcon(R.drawable.doc5);
        DoctorEntity doctorEntity6= new DoctorEntity(6,"Dr. Roberto Cruz","Dermatologia","Sede La Molina",true,2);
        doctorEntity6.setIcon(R.drawable.doc6);
        DoctorEntity doctorEntity7= new DoctorEntity(7,"Dr. Enrique Peña","Traumatologia","Sede Jesus Maria",true,2);
        doctorEntity7.setIcon(R.drawable.doc7);
        DoctorEntity doctorEntity8= new DoctorEntity(8,"Dr. Jose Zegarra","Cardiologia","Sede La Molina",true,3);
        doctorEntity8.setIcon(R.drawable.doc8);
        DoctorEntity doctorEntity9= new DoctorEntity(9,"Dr. Eduardo Leon","Oftalmologia","Sede Los Olivos",true,4);
        doctorEntity9.setIcon(R.drawable.doc9);
        DoctorEntity doctorEntity10= new DoctorEntity(10,"Dr. Ricardo Lara","Dermatologia","Sede Los Olivos",true,4);
        doctorEntity10.setIcon(R.drawable.doc10);
        DoctorEntity doctorEntity11= new DoctorEntity(11,"Dra. Rita Gomez","Endocrinologia","Sede Miraflores",true,3);
        doctorEntity11.setIcon(R.drawable.doc11);
        DoctorEntity doctorEntity12= new DoctorEntity(12,"Dr. Jesus Fernandez","Traumatologia","Sede La Molina",true,1);
        doctorEntity12.setIcon(R.drawable.doc12);

        lsDoctorEntities.add(doctorEntity);
        lsDoctorEntities.add(doctorEntity1);
        lsDoctorEntities.add(doctorEntity2);
        lsDoctorEntities.add(doctorEntity4);
        lsDoctorEntities.add(doctorEntity5);
        lsDoctorEntities.add(doctorEntity6);
        lsDoctorEntities.add(doctorEntity7);
        lsDoctorEntities.add(doctorEntity8);
        lsDoctorEntities.add(doctorEntity9);
        lsDoctorEntities.add(doctorEntity10);
        lsDoctorEntities.add(doctorEntity11);
        lsDoctorEntities.add(doctorEntity12);

    }

    public List<DoctorEntity> allDoctor()
    {
        return this.lsDoctorEntities;
    }

}
