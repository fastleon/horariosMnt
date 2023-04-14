package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.respositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService{
    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento createEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> getEventos() {
        return null;
    }

    @Override
    public Optional<Evento> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Evento> updateUser(Evento evento, Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserbyId(Long id) {

    }
}
