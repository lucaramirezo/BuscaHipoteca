package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        String mi_variable = "hello amigo";
        return mi_variable;
    }
    
    
}
