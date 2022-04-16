package com.marsh.iStore.service;

import com.marsh.iStore.model.User;
import com.marsh.iStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllListUser(){
        return userRepository.findAll();
    }

    public User getUserByUsername(String login){
        return userRepository.findByUsername(login);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
