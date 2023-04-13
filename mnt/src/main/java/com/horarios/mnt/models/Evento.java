package com.horarios.mnt.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="Eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Integer ident;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String tipo;

    public Evento(Long id, String date, Integer ident, String nombre, String tipo) {
        this.id = id;
        this.date = date;
        this.ident = ident;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Evento(String date, Integer ident, String nombre, String tipo) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
