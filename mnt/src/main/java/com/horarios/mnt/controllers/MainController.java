package com.horarios.mnt.controllers;

import com.horarios.mnt.models.User;
import com.horarios.mnt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
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
    @GetMapping("/listado")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        //("Visualizar los datos de un trabajador con opcion de editar y guardar");
        Optional<User> user1 = userService.getUserById(id);
        if (user1.isPresent()){
            System.out.println("devolviendo datos del usuario" + id);
            return user1.get();
        }else{
            System.err.println("No se encontró el id seleccionado");
            return null;
        }
    }

    @PutMapping("/{id}")
    public User editUserById(@RequestBody User user, @PathVariable("id") Long id){
        System.err.println("solicitud para editar ID:"+ id + " con el usuario:\n" + user);
        Optional<User> user1 = userService.updateUser(user, id);
        if (user1.isPresent()){
            System.out.println("devolviendo datos del usuario editado" + id);
            return user1.get();
        }else {
            System.err.println("No se logró editar el usuario " + id);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserbyId(id);
    }

}
