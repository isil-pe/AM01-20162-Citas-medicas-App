package com.isil.activities.model;

import java.io.Serializable;
/**
 * Created by Pablo on 11/4/2016.
 */

public class DoctorEntity implements Serializable {

    private int id;
    private String name;
    private String category;
    private boolean available;
    private String location;
    private int icon;
    private int schedule;

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }



   /* public DoctorEntity(int id, String name, String category, String location, int schedule){
        this.id =id;
        this.name=name;
        this.category=category;
        this.location= location;

        this.schedule =schedule;

    }*/

    public DoctorEntity(int id, String name, String category, String location, boolean available, int schedule){
        this.id =id;
        this.name=name;
        this.category=category;
        this.location= location;

        this.available =available;
        this.schedule =schedule;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    /* public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }*/
}
