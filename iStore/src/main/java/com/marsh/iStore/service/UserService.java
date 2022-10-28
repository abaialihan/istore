package com.marsh.iStore.service;

import com.marsh.iStore.model.User;
import com.marsh.iStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

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

//    public String cheekUserFromDb(User user, Model model){
//        User userFromDb = this.getUserByUsername(user.getUsername());
//
//        if(userFromDb != null){
//            model.addAttribute("userExists", "Login занят");
//            return "registration";
//        }
//    }
}
