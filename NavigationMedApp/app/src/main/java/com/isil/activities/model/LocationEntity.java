package com.isil.activities.model;

import java.io.Serializable;

/**
 * Created by Pablo on 11/27/2016.
 */

public class LocationEntity implements Serializable{

    private int id;
    private String nombre;
    private String categoria;
    private String direccion;
    private String telefono;
    private String descripcion;
    private int photo;

    public LocationEntity( int id,String nombre,String categoria,String direccion,String telefono,String descripcion){

        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.telefono = telefono;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
