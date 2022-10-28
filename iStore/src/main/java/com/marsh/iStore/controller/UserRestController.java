package com.marsh.iStore.controller;

import com.marsh.iStore.model.User;
import com.marsh.iStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("api/v1/users")
    public List<User> getAllUsers(){
        return userService.getAllListUser();
    }

    @GetMapping("api/v1/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id){
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/v1/users/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}
