package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonImportService {


    public List<Evento> importData() {
        Evento evento1 = new Evento(1l,"fecha1", 123,"Alejandro Leon");
        Evento evento2 = new Evento(2l,"fecha2", 223,"Paola Palacios");
        Evento evento3 = new Evento(3l,"fecha3", 323,"Christian Ruiz");
        ArrayList<Evento> eventos = new ArrayList<Evento>() {};
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        return eventos;
    }
/*
        JSONParser parser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/static/test.json"));

            // loop through each object in the array
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String nombre = (String) jsonObject.get("nombre");
                String email = (String) jsonObject.get("email");
                String alias = (String) jsonObject.get("alias");
                String password = (String) jsonObject.get("password");
                //JSONArray cars = (JSONArray) jsonObject.get("cars");


                System.out.print("nombre: " + nombre);
                System.out.print(" email: " + email);
                System.out.print(" alias: " + alias);
                System.out.print(" password: " + password);
                /*System.out.println("Cars:");
                for (Object car : cars) {
                    System.out.println("   " + car.toString());
                }/
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
}


