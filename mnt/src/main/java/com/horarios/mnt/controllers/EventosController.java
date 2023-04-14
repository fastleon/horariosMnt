package com.horarios.mnt.controllers;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.services.EventoService;
import com.horarios.mnt.services.JsonImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/eventos")
@RestController
public class EventosController {

    @Autowired
    private EventoService eventoService;

    private JsonImportService jsonImportService = new JsonImportService();

    //Llamado al archivo en Static folder
    @GetMapping("/import-time")
    public List<Evento> importData(){
        List<Evento> eventosImportados = jsonImportService.importData();

        for (Evento evento: eventosImportados){
            Date date = new Date();
            Evento evento1 = new Evento(
                    evento.getDate(),
                    evento.getIdent(),
                    evento.getNombre(),
                    evento.getTipo()
            );
            eventoService.createEvento(evento1);
        }
        return eventosImportados;
    }

    //

}
