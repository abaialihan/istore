package com.marsh.iStore.controller.restController;

import com.marsh.iStore.model.User;
import com.marsh.iStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
