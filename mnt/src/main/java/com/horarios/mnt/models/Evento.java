package com.horarios.mnt.models;

import java.sql.Date;

public class Evento {
    private Long id;
    private String date;
    private Integer ident;
    private String nombre;

    public Evento(Long id, String date, Integer ident, String nombre) {
        this.id = id;
        this.date = date;
        this.ident = ident;
        this.nombre = nombre;
    }

    public Evento(String date, Integer ident, String nombre) {
        this.date = date;
        this.ident = ident;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIdent() {
        return ident;
    }

    public void setIdent(Integer ident) {
        this.ident = ident;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", date=" + date +
                ", ident=" + ident +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
