package com.horarios.mnt.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User {

    //Id, nombre, email, alias, password
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Evento> evento = new ArrayList<>();

    public User() {
    }

    public User(Long id, String nombre, String email, String alias, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.alias = alias;
        this.password = password;
    }

    public User(String nombre, String email, String alias, String password) {
        this.nombre = nombre;
        this.email = email;
        this.alias = alias;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", alias='" + alias + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
