package com.horarios.mnt.services;

import com.horarios.mnt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public void createUser(User user);

    public List<User> getUsers();

    public Optional<User> getUserById(Long id);

    public Optional<User> updateUser(User user);

    public void deleteUserbyId(Long id);

    public Optional<User> getUserByAlias(String alias);

}
