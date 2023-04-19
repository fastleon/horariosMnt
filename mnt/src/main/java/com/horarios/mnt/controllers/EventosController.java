package com.horarios.mnt.controllers;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.models.EventoNoSQL;
import com.horarios.mnt.models.User;
import com.horarios.mnt.services.EventoService;
import com.horarios.mnt.services.EventoServiceDao;
import com.horarios.mnt.services.JsonImportService;
import com.horarios.mnt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/eventos")
@RestController
public class EventosController {

    @Autowired
    private EventoServiceDao eventoService;
    @Autowired
    private UserService userService;

    private JsonImportService jsonImportService = new JsonImportService();

    //Llamado al archivo en Static folder
    @GetMapping("/import-time")
    public List<Evento> importData(){
        //los temas leidos vienen sin procesar ni ligar a los datos de user en la DB
        List<EventoNoSQL> eventosImportados = jsonImportService.importData();
        List<Evento> eventosGuardados = new ArrayList<Evento>();
        for (EventoNoSQL eventoNoSQL: eventosImportados) {
            //Revisar el dato para ligarlo a un usuario y revisar que no exista actualmente en la BD
            try {
                Optional<User> user1 = userService.getUserByAlias(eventoNoSQL.getNombre());
                if (user1.isPresent()) {
                    Evento evento1 = new Evento(
                            eventoNoSQL.getDate(),
                            eventoNoSQL.getIdent(),
                            user1.get(),
                            eventoNoSQL.getTipo()
                    );
                    eventoService.createEvento(evento1);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println("No se puede crear este evento");
            }
        }
        return eventosGuardados;
    }

    @GetMapping("/get-events/{starDate}/{endDate}")
    public List<Evento> getEventos(@PathVariable("starDate") String startDate, @PathVariable("endDate") String endDate){
        System.err.println(startDate + "," + endDate);
        try {
            System.err.println(parseDate(startDate, "yyyy-MM-dd") + "," + parseDate(endDate, "yyyy-MM-dd"));
            return eventoService.getEventos(parseDate(startDate, "yyyy-MM-dd"),parseDate(endDate, "yyyy-MM-dd"));
            //return eventoService.getEventos(startDate,endDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static Date parseDate(String dateString, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateString);
        return date;
    }

}
