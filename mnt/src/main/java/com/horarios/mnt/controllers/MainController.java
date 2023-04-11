package com.horarios.mnt.controllers;

import com.horarios.mnt.models.User;
import com.horarios.mnt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String pruebaConexion(){
        return ("Prueba OK");
    }

    @PostMapping("/addUsuario")
    public User crearUsuario(@RequestBody User user){
        //("Creacion de usuario en la base de datos");
        System.err.println(user.toString());
        return userService.createUser(user);
    }
    @GetMapping("/usuarios")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/usuarios/{id}")
    public String verUsuarioById(@PathVariable("id") Long id){
        return("Visualizar los datos de un trabajador con opcion de editar y guardar");
        //return(User)
    }

    @PutMapping("/usuarios/{id}")
    public String editarUsuarioById(@RequestBody User usuario, @PathVariable("id") Long id){
        return("Editar los datos de un usuario, usa metodo PUT(User,id");
    }

    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuarioById(@PathVariable("id") Long id){
        return("Eliminar los datos de un usuario, metodo Delete");
    }

}
