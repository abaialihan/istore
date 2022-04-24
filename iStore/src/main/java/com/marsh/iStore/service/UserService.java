package com.marsh.iStore.service;

import com.marsh.iStore.model.User;
import com.marsh.iStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllListUser(){
        return userRepository.findAll();
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

//    Загружать пользователей по имени пользователя 。
//    Этот метод в основном используется для запроса и загрузки определенных пользователей
//    из системных данных в Spring Security.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
