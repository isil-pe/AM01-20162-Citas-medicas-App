package com.isil.activities.model;

/**
 * Created by Pablo on 11/30/2016.
 */

public class ScheduleEntity {
    private int id;
    private String horario;

    public ScheduleEntity(int id, String horario){

        this.id=id;
        this.horario=horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
