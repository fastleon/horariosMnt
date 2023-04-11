package com.horarios.mnt.controllers;

import com.horarios.mnt.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("/")
    public String pruebaConexion(){
        return ("Prueba OK");
    }

    @PostMapping("/addUsuario")
    public String crearUsuario(User user){
        return ("Creacion de usuario en la base de datos");
        //return
    }
    @GetMapping("/usuarios")
    public String verUsuarios(){
        return ("Visualizar lista de trabajadores con opcion de editar y eliminar");
        //return List<User>
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
