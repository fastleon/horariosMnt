package com.horarios.mnt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String pruebaConexion(){
        return ("Prueba OK");
    }
}
