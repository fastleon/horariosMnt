package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventoServiceDao implements EventoService{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createEvento(Evento evento) {
        entityManager.persist(evento);
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
