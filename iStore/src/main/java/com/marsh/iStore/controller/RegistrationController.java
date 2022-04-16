package com.marsh.iStore.controller;

import com.marsh.iStore.model.Role;
import com.marsh.iStore.model.User;
import com.marsh.iStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(User user, Model model){
        User userFromDb = userService.getUserByUsername(user.getUsername());

        if(userFromDb != null){
            model.addAttribute("userExists", "User Exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/login";
    }
}
