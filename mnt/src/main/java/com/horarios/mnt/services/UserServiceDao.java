package com.horarios.mnt.services;

import com.horarios.mnt.models.User;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceDao implements UserService{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.ofNullable(entityManager.merge(user));
    }

    @Override
    public void deleteUserbyId(Long id) {
        entityManager.remove(id);
    }

    @Override
    public Optional<User> getUserByAlias(String alias) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.alias = :alias", User.class);
        query.setParameter("alias", alias);
        try {
            return Optional.ofNullable(query.getSingleResult());
        }catch (Exception e){
            System.err.println("No se encontro ese alias en el listado " + alias);
            return Optional.empty();
        }
    }
}
