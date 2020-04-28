package com.springboot.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
public class HomeController {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World..";
    }
}
