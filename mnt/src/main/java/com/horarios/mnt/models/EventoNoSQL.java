package com.horarios.mnt.models;

import java.util.Date;

public class EventoNoSQL {

    private Long id;

    private Date date;

    private Integer ident;

    private String nombre;

    private String tipo;

    public EventoNoSQL(Long id, Date date, Integer ident, String nombre, String tipo) {
        this.id = id;
        this.date = date;
        this.ident = ident;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public EventoNoSQL(Date date, Integer ident, String nombre, String tipo) {
        this.date = date;
        this.ident = ident;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
