package com.isil.activities.storage;

import com.isil.activities.model.DoctorEntity;
import com.isil.activities.model.ScheduleEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Pablo on 11/30/2016.
 */

public class DoctorByCategoryRepository {

    private List<DoctorEntity> doctors;
    private final DoctorRepository doctorRepository;

    public DoctorByCategoryRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        doctors = new ArrayList<DoctorEntity>();
    }



    public  List<DoctorEntity> getDoctorByCategory(int category){

        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (DoctorEntity doctorEntity : doctorRepository.allDoctor()) {
            if(doctorEntity.getSchedule()==category){

                doctorEntities.add(doctorEntity);
            }
        }
        return doctorEntities;
    }
}
