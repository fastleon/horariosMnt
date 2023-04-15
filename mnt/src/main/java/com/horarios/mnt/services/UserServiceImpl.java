/*package com.horarios.mnt.services;

import com.horarios.mnt.models.User;
import com.horarios.mnt.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user, Long id) {
        Optional<User> resultado = Optional.empty();
        if (userRepository.findById(id).isPresent()) {
            User user1 = new User();
            user1 = userRepository.findById(id).get();
            user1.setNombre(user.getNombre());
            user1.setEmail(user.getEmail());
            user1.setAlias(user.getAlias());
            user1.setPassword(user.getPassword());
            resultado = Optional.ofNullable (userRepository.save(user1));
        }
        return resultado;
    }

    @Override
    public void deleteUserbyId(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User GetUserByAlias(String alias) {
        return userRepository.
    }
}*/
