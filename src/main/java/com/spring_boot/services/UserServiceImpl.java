package com.spring_boot.services;

import com.spring_boot.dao.UserRepository;
import com.spring_boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserById(int id) {
        User users = null;
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            users = userOptional.get();
        }
        return userOptional;
    }

}
