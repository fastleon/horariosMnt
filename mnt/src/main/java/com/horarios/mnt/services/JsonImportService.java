package com.horarios.mnt.services;

import com.horarios.mnt.models.EventoNoSQL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonImportService {

    public List<EventoNoSQL> importData() {
        ArrayList<EventoNoSQL> eventos = new ArrayList<EventoNoSQL>() {};

        try {
            //Seleccionar el archivo
            //Casa
            String pathJson = "C:\\ProgramacionCodigos\\Java\\horariosMnt\\horariosMnt\\mnt\\src\\main\\resources\\static\\test.json";
            //Empresa
            //String pathJson = "C:\\Users\\Alejo\\Desktop\\AppHorarios\\BackEnd\\mnt\\src\\main\\resources\\static\\test.json";

            //leer el archivo seleccionado en pathJson
            String contents = new String(Files.readAllBytes(Paths.get(pathJson)));
            //Crear un objeto tipo jsonArray, aplica porque esperamos un array de datos Json
            JSONArray jsonArray = new JSONArray(contents);

            //Leemos cada registro del archivo de texto
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String tiempo = jsonObject.getString("Tiempo");
                Date date = Date.from(Instant.parse(tiempo));
                Integer idUsuario = jsonObject.getInt("ID de Usuario");
                String nombre = jsonObject.getString("Nombre");

                System.out.println(date + " | " + idUsuario + " | " + nombre);
                EventoNoSQL evento1 = new EventoNoSQL(0l, date, idUsuario, nombre, "entrada-salida");
                eventos.add(evento1);
                }
            System.out.println("Encontrados " + jsonArray.length() + " datos en el archivo Json, pasando a inspeccionar base de datos");
            } catch (IOException e) {
                e.printStackTrace();
            }
        //devolvemos los eventos adquiridos
        return eventos;
    }
}


