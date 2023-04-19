package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface EventoService {

    public void createEvento(Evento evento);

    public List<Evento> getEventos(Date startDate, Date endDate);

    public Optional<List<Evento>> getEventoByIdAndDate(Long id, Date date, Boolean isOnlyOne);

    public Optional<List<Evento>> getEventosbyDate(Date date);

    public Optional<Evento> updateUser(Evento evento, Long id);

    public void deleteEventobyId(Long id);

}
