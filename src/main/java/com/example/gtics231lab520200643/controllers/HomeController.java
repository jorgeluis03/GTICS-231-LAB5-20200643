package com.example.gtics231lab520200643.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/inicio")
    public String inicio (){
        return "vistaInicial";
    }
}
