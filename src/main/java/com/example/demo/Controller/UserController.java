package com.example.demo.Controller;

import com.example.demo.Entity.Person;

import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public List<Person> login() {

        return userService.selectAllUser();
    }
}
