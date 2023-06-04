package com.example.grupo1.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class GreetingController {

    @GetMapping("/greeting")
    public String saludar(){
        return "Estoy saludando desde el grupo 1";
    }


}
