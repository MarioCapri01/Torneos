package com.game.tournaments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.tournaments.model.Torneo;
import com.game.tournaments.service.TorneoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/torneos")
public class TorneosController {
    private final TorneoService service;
    public TorneosController(TorneoService service){
        this.service = service;
    }
    //private final TorneoService torneoCont;
    @GetMapping("/holamundo")
    public String getHolaMundo() {
        return "Hola Mundo";
    }
    @PostMapping("/new")
    public ResponseEntity<Torneo> nuevoTorneo(@RequestBody Torneo entity) {
        Torneo torneo = service.creaTorneo(entity.getNombreTorneo(), entity.getTipoTorneo());
        return ResponseEntity.status(HttpStatus.CREATED).body(torneo);
    } 
    /*@GetMapping("/allTorneos")
    public ResponseEntity<List<Torneo>> getTorneos() {
        return ResponseEntity.ok(service.getAllTorneos());
    }*/
    
    
}
