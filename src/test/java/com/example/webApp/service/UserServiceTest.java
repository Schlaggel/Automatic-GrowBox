package com.example.webApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void findByUsernameWithDevices() {
    }

//    @Test
//    void findAllUsers(){
//        List<UserDTONotLazy> users = userService.findAll();
//    }
}