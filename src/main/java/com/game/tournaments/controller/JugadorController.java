package com.game.tournaments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.tournaments.model.Jugador;
import com.game.tournaments.service.JugadorService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/jugador")
public class JugadorController {
    private final JugadorService service;
    public JugadorController(JugadorService service){
        this.service = service;
    }
    @PostMapping("/new")
    public ResponseEntity<Jugador> nuevoJugador(@RequestBody Jugador entity) {
        Jugador jugador = service.creaJugador(entity.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(jugador);
    } 
    @GetMapping("/allJugadores")
    public ResponseEntity<List<Jugador>> getJugadores() {
        return ResponseEntity.ok(service.getAllJugadores());
    }
    
}
