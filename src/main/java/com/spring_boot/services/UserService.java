package com.spring_boot.services;

import com.spring_boot.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    Optional<User> getUserById(int id);

}
