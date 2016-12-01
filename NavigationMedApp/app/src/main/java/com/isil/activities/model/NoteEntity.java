package com.isil.activities.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 29/10/15.
 */
public class NoteEntity implements Serializable{

    public static  final String TIMESTAMP_FIELD="addedDate";

    private int id;
    private String name;
    private String description;
    private String path;
    private String addedDate;
    private String color;
    private int icon;


    private String espec;
    private String doctor;

    public String getEspec() {
        return espec;
    }

    public void setEspec(String espec) {
        this.espec = espec;
    }

    public NoteEntity(int id, String name, String description, String addedDate, String doctor, String espec ) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.addedDate = addedDate;
        this.doctor = doctor;
        this.espec=espec;

    }

    public NoteEntity(int id, String name, String description, String doctor, String espec) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.doctor=doctor;
        this.espec=espec;
    }

    public NoteEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
