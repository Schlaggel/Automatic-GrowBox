package com.example.webApp.controller;

import com.example.webApp.Servie.UserService;
import com.example.webApp.repository.RoleRepository;
import com.example.webApp.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@ComponentScan
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUsers(User user) throws ValidationException {
        userService.saveUser(user);
        return "redirect:/login";
}
    }


