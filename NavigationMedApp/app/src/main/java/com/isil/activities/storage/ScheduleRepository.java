package com.isil.activities.storage;

import com.isil.activities.model.ScheduleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 12/1/2016.
 */

public class ScheduleRepository {

    private List<ScheduleEntity> schedules;

    public ScheduleRepository(){ schedules= new ArrayList<ScheduleEntity>();}

    public void mock() {


        ScheduleEntity schedule = new ScheduleEntity(1,"9:00-12:00 hrs");
        ScheduleEntity schedule1 = new ScheduleEntity(2,"12:00-15:00 hrs");
        ScheduleEntity schedule2 = new ScheduleEntity(3,"15:00-18:00 hrs");
        ScheduleEntity schedule3 = new ScheduleEntity(4,"18:00-20:00 hrs");


        schedules.add(schedule);
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedules.add(schedule3);
    }
}
