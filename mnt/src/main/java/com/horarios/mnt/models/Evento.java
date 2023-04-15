package com.horarios.mnt.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Integer ident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    private String tipo;



    public Evento(Long id, Date date, Integer ident, User user, String tipo) {
        this.id = id;
        this.date = date;
        this.ident = ident;
        this.user = user;
        this.tipo = tipo;
    }
    public Evento(Date date, Integer ident, User user, String tipo) {
        this.date = date;
        this.ident = ident;
        this.user = user;
        this.tipo = tipo;
    }
    public Evento() {}

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

    public User getNombre() {
        return user;
    }

    public void setNombre(User nombre) {
        this.user = nombre;
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
                ", nombre='" + user.getNombre() + '\'' +
                '}';
    }

}
