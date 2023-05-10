package com.horarios.mnt.services;

import com.horarios.mnt.models.Evento;
import com.horarios.mnt.models.User;
import jakarta.persistence.*;
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
    public Optional<Evento> getExactEventoByIdAndDate(Long id, Date date) {
        //Se busca la fecha y hora exacta para ese usuario, usado en funcion donde se guardan o no nuevos eventos a la BD

        System.err.println("1-"+id+","+date.toString());
        String query = "SELECT e " +
                "FROM Evento e " +
                "WHERE e.user.id = :userId " +
                "AND e.date = :date";
        TypedQuery<Evento> typedQuery = entityManager.createQuery(query, Evento.class);
        typedQuery.setParameter("userId", id);
        typedQuery.setParameter("date", date);
        try {
            Evento evento = typedQuery.getSingleResult();
            System.err.println("Encontre un resultado");
            return Optional.ofNullable(evento);
        }catch (NoResultException e) {
            // hacer algo si no hay resultados
            System.out.println("No se encontraron resultados");
            return Optional.empty();
        }catch (Exception e){
            System.err.println("falla al crear busqueda en hibernate, funcion getExactEventoByIdAndDate");
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Evento>> getEventosByIdAndDate(Long id, Date date) {
        System.err.println("1-"+id+","+date.toString());
        String query = "SELECT e " +
                "FROM Evento e " +
                "WHERE e.user.id = :userId " +
                "AND date(e.date) = :date";
        TypedQuery<Evento> typedQuery = entityManager.createQuery(query, Evento.class);
        typedQuery.setParameter("userId", id);
        typedQuery.setParameter("date", date);
        try {
            List<Evento> eventos = typedQuery.getResultList();
            System.err.println("Encontre resultados, " + eventos.size());
            return Optional.ofNullable(eventos);
        }catch (NoResultException e) {
            // hacer algo si no hay resultados
            System.out.println("No se encontraron resultados");
            return Optional.empty();
        }catch (Exception e){
            System.err.println("falla al crear busqueda en hibernate, funcion getEventosByIdAndDate");
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Evento>> getEventosbyDate(Date date) {
        return Optional.empty();
    }

    @Override
    public Evento getEventoById(Long id) {
        return entityManager.find(Evento.class, id);
    }

    @Override
    public Optional<Evento> updateEvento(Evento evento) {
        return Optional.empty();
    }


    @Override
    public void deleteEventobyId(Long id) {

    }
}
