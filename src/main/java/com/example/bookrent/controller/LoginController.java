package com.example.bookrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookRent")
public class LoginController {

    @GetMapping("/welcome")
    public String welcomePage(){
        return "Welcome!";
    }
}
