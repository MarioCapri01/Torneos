package com.game.tournaments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.tournaments.model.Jugador;
import com.game.tournaments.model.Participacion;
import com.game.tournaments.model.ParticipacionIds;
import com.game.tournaments.model.Torneo;
import com.game.tournaments.service.ParticipacionService;
import com.game.tournaments.service.JugadorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/participacion")
public class ParticipacionController {
    private final ParticipacionService partService;
    public ParticipacionController(ParticipacionService service){
        this.partService = service;
    }
    @PostMapping("/new")
    public ResponseEntity<Participacion> nuevaParticipacion(@RequestBody ParticipacionIds entity){
    //public ResponseEntity<Participacion> nuevaParticipacion(@RequestBody Participacion entity){
        System.out.println("---------------");
        //TODO: Get torbeo by id
        System.out.println(partService.getJugadorById(entity.getIdJugador()));
        System.out.println(partService.getTorneoById(entity.getIdTorneo()));
        System.out.println("---------------");
        Participacion participacion = partService.creaParticipacion(partService.getTorneoById(entity.getIdTorneo()),partService.getJugadorById(entity.getIdJugador()));
        return ResponseEntity.status(HttpStatus.CREATED).body(participacion);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Participacion> nuevoParticipante(@PathVariable int id, @Valid @RequestBody Jugador entity) {
        Participacion participacion = partService.nuevoParticipante(id,entity);
        return ResponseEntity.status(HttpStatus.OK).body(participacion);
    }


}
