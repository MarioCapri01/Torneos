package com.game.tournaments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.tournaments.model.Jugador;
import com.game.tournaments.model.Participacion;
import com.game.tournaments.service.ParticipacionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/participacion")
public class ParticipacionController {
    private final ParticipacionService service;
    public ParticipacionController(ParticipacionService service){
        this.service = service;
    }
    @PostMapping("/new")
    public ResponseEntity<Participacion> nuevaParticipacion(@RequestBody Participacion entity){
        Participacion participacion = service.creaParticipacion(entity.getTorneo(), entity.getJugador());
        return ResponseEntity.status(HttpStatus.CREATED).body(participacion);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Participacion> nuevoParticipante(@PathVariable int id, @Valid @RequestBody Jugador entity) {
        Participacion participacion = service.nuevoParticipante(id,entity);
        return ResponseEntity.status(HttpStatus.OK).body(participacion);
    }
}
