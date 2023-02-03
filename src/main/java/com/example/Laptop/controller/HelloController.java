package com.example.Laptop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //atributos


    //constructores

    public HelloController() {
    }

    //metodo
    @GetMapping("/hola")
    public String hola(){
        return "holaa";
    }
    }




    //getters and setter


