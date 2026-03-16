package com.game.tournaments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/torneos")
public class TorneosController {
    @GetMapping("/holamundo")
    public String getHolaMundo() {
        return "Hola Mundo";
    }
    
}
