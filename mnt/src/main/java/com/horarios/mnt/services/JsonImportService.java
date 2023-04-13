package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import net.minidev.json.writer.JsonReader;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonImportService {


    public List<Evento> importData() {
        Evento evento1 = new Evento(1l, "fecha1", 123, "Alejandro Leon");
        Evento evento2 = new Evento(2l, "fecha2", 223, "Paola Palacios");
        Evento evento3 = new Evento(3l, "fecha3", 323, "Christian Ruiz");
        ArrayList<Evento> eventos = new ArrayList<Evento>() {};
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);

        //JSONParser parser = new JSONParser();
        try {
            String pathJson = "C:\\Users\\Alejo\\Desktop\\AppHorarios\\BackEnd\\mnt\\src\\main\\resources\\static\\test.json";

                String contents = new String(Files.readAllBytes(Paths.get(pathJson)));
                JSONArray jsonArray = new JSONArray(contents);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String tiempo = jsonObject.getString("Tiempo");
                    String idUsuario = jsonObject.getString("ID de Usuario");
                    String nombre = jsonObject.getString("Nombre");

                    System.out.println(tiempo + " | " + idUsuario + " | " + nombre);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return eventos;
    }
}


