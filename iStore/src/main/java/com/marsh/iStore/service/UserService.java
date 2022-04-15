package com.marsh.iStore.service;

import com.marsh.iStore.entity.User;
import com.marsh.iStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllListUser(){
        return userRepository.findAll();
    }

    public User getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
