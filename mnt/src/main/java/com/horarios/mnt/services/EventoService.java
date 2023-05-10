package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.models.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface EventoService {

    public void createEvento(Evento evento);

    public List<Evento> getEventos(Date startDate, Date endDate);

    public Optional<Evento> getExactEventoByIdAndDate(Long id, Date date);

    public Optional<List<Evento>> getEventosByIdAndDate(Long id, Date date);

    public Optional<List<Evento>> getEventosbyDate(Date date);

    public Evento getEventoById(Long id);

    public Optional<Evento> updateEvento(Evento evento);

    public void deleteEventobyId(Long id);

}
