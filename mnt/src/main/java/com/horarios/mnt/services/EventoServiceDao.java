package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Evento> getEventos(Date startDate, Date endDate) {
        String query = "SELECT u FROM Evento u ";
        query += "WHERE u.date BETWEEN :starDate AND :endDate";
        TypedQuery<Evento> typedQuery = entityManager.createQuery(query, Evento.class);
        typedQuery.setParameter("starDate", startDate);
        typedQuery.setParameter("endDate", endDate);
        try {
            return typedQuery.getResultList();
        }catch (Exception e){
            System.err.println("No se encontraron datos en ese rango de fechas");
            return null;
        }
    }

    @Override
    public Optional<List<Evento>> getEventoByIdAndDate(Long id, Date date, Boolean isOnlyOne) {
        //Buscar por id y fecha, la opcion onlyone es verdadero si se busca el dato exacto de la fecha hora,
        //falso para solo el dia
        return Optional.empty();
    }

    @Override
    public Optional<List<Evento>> getEventosbyDate(Date date) {
        return Optional.empty();
    }


    @Override
    public Optional<Evento> updateUser(Evento evento, Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteEventobyId(Long id) {

    }
}
