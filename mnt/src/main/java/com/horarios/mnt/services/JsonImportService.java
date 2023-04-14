package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.respositories.EventoRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonImportService {

    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> importData() {
        ArrayList<Evento> eventos = new ArrayList<Evento>() {};

        try {
            //Seleccionar el archivo
            String pathJson = "C:\\ProgramacionCodigos\\Java\\horariosMnt\\horariosMnt\\mnt\\src\\main\\resources\\static\\test.json";

            String contents = new String(Files.readAllBytes(Paths.get(pathJson)));
            JSONArray jsonArray = new JSONArray(contents);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String tiempo = jsonObject.getString("Tiempo");
                Date date = Date.from(Instant.parse(tiempo));
                Integer idUsuario = jsonObject.getInt("ID de Usuario");
                String nombre = jsonObject.getString("Nombre");

                System.out.println(date + " | " + idUsuario + " | " + nombre);
                /*Evento evento1 = new Evento();
                evento1.setDate(date);
                evento1.setIdent(idUsuario);
                evento1.setNombre(nombre);
                evento1.setNombre("entrada-salida");*/
                Evento evento1 = new Evento(date, idUsuario, nombre, "entrada-salida");
                eventos.add(evento1);
                eventoRepository.save(evento1);
                }
            System.out.println("Agregados " + jsonArray.length() + " datos a la base de datos");
            } catch (IOException e) {
                e.printStackTrace();
            }

        return eventos;
    }
}


