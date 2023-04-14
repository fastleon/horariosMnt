package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventoService {

    public Evento createEvento(Evento evento);

    public List<Evento> getEventos();

    public Optional<Evento> getUserById(Long id);

    public Optional<Evento> updateUser(Evento evento, Long id);

    public void deleteUserbyId(Long id);

}
