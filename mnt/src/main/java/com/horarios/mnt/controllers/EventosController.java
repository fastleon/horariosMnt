package com.horarios.mnt.controllers;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.models.EventoNoSQL;
import com.horarios.mnt.models.User;
import com.horarios.mnt.services.EventoServiceDao;
import com.horarios.mnt.services.JsonImportService;
import com.horarios.mnt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public List<Evento> importData() {
        //los temas leidos vienen sin procesar ni ligar a los datos de user en la DB
        List<EventoNoSQL> eventosImportados = jsonImportService.importData();
        List<Evento> eventosGuardados = new ArrayList<Evento>();
        for (EventoNoSQL eventoNoSQL : eventosImportados) {
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
                    System.err.println("Revisando " + evento1.getUser().getNombre() + ", fecha: " + evento1.getDate());
                    if (!eventoService.getExactEventoByIdAndDate(evento1.getUser().getId() , evento1.getDate() ).isPresent() ) {
                        System.err.println("Ingresando nuevo valor");
                        eventoService.createEvento(evento1);
                    }else{
                        System.err.println("valor ya existente");
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println("No se puede crear este evento");
            }
        }
        return eventosGuardados;
    }

    @GetMapping("/get-events/{starDate}/{endDate}")
    public List<EventoNoSQL> getEventos(@PathVariable("starDate") String startDate, @PathVariable("endDate") String endDate) {
        try {
            Date newEndDate = parseDate(endDate, "yyyy-MM-dd");
            newEndDate = modificarFecha(newEndDate,"+",1);
            Date newStartDate = parseDate(startDate, "yyyy-MM-dd");
            System.err.println(newStartDate + ", " + newEndDate);
            return eventoNoSQLS(eventoService.getEventos(newStartDate, newEndDate));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public EventoNoSQL getEventById(@PathVariable("id") Long id) {
        Evento evento = eventoService.getEventoById(id);
        return (eventoToJson(evento));
    }

    @GetMapping("/{id}/{date}")
    public List<EventoNoSQL> getEventById(@PathVariable("id") Long id,@PathVariable("date") String date) {
        //Devuelve todos los eventos del día para el usuario con ese id
        List<EventoNoSQL> eventosNoSQL = new ArrayList<EventoNoSQL>();
        try {
            Date searchDate = parseDate(date, "yyyy-MM-dd");
            System.err.println("id:" + id + " fecha:" + date);
            Optional<List<Evento>> eventos = eventoService.getEventosByIdAndDate(id, searchDate);
            eventos.ifPresentOrElse(listaEventos -> {
                for (Evento evento : listaEventos) {
                    eventosNoSQL.add(eventoToJson(evento));
                }
            }, () -> {
                System.err.println("No se encontró ningun evento para ese User y esa fecha");
            });
            return (eventosNoSQL);
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("No logré traer los datos de los eventos para ese id y esa fecha");
            return (null);
        }
    }

    public static Date parseDate(String dateString, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateString);
        return date;
    }

    public static EventoNoSQL eventoToJson(Evento evento) {
        EventoNoSQL eventoNoSQL = new EventoNoSQL(
                evento.getId(),
                evento.getDate(),
                evento.getIdent(),
                evento.getUser().getNombre(),
                evento.getTipo()
        );
        return eventoNoSQL;
    }

    public static List<EventoNoSQL> eventoNoSQLS(List<Evento> eventos) {
        List<EventoNoSQL> eventosNoSql = new ArrayList<EventoNoSQL>();
        for (Evento evento : eventos) {
            eventosNoSql.add(eventoToJson(evento));
        }
        return eventosNoSql;
    }

    public static Date modificarFecha(Date date, String modifier, Integer numDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // set the calendar time to the given date
        Date newDate = calendar.getTime(); // get the updated date
        System.out.println(newDate);

        if (modifier == "+") {
            calendar.add(Calendar.DAY_OF_YEAR, numDays); // add one day to the date
        } else if (modifier == "-") {
            calendar.add(Calendar.DAY_OF_YEAR, numDays * -1);
        } else {
            System.err.println("Error en la funcion modificarFecha, se devuelve la misma fecha");
        }
        return calendar.getTime();
    }
}
