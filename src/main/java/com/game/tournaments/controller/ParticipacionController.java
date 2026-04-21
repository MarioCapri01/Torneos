package com.game.tournaments.controller;

import com.game.tournaments.repository.JugadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.game.tournaments.model.Emparejamiento;
import com.game.tournaments.model.Jugador;
import com.game.tournaments.model.Participacion;
import com.game.tournaments.model.ParticipacionIds;
import com.game.tournaments.model.Torneo;
import com.game.tournaments.service.ParticipacionService;
import com.game.tournaments.service.JugadorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participacion")
public class ParticipacionController {
    private final JugadorRepository jugadorRepository;
    private final JugadorController jugadorController;
    private final ParticipacionService partService;
    public ParticipacionController(ParticipacionService service, JugadorController jugadorController, JugadorRepository jugadorRepository){
        this.partService = service;
        this.jugadorController = jugadorController;
        this.jugadorRepository = jugadorRepository;
    }
    @PostMapping("/new")
    public ResponseEntity<Participacion> nuevaParticipacion(@RequestBody ParticipacionIds entity){
        //TODO: Validacion de id de jugador y torneo correctos
        Participacion participacion = partService.creaParticipacion(partService.getTorneoById(entity.getIdTorneo()),partService.getJugadorById(entity.getIdJugador()));
        return ResponseEntity.status(HttpStatus.CREATED).body(participacion);
    }
    @RequestMapping(value = "/getParticipaciones/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getParticipaciones(@PathVariable int id) {
        //TODO: Validacion de id correcto
        List<Integer> lista = partService.getParticipacionesById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    //TODO: Metodo para obtener emparejamiento a partir de participaciones
    @RequestMapping(value = "/getEmparejamientos/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Emparejamiento>> getEmparejamientos(@PathVariable int id) {
        List<Integer> listaParticipantes = partService.getParticipacionesById(id);
        //List<Jugador> listaParticipantes = partService.getJugadoresById(id;)
        List<Emparejamiento> listaEmparejamientos = new ArrayList<>();
        //Mínimo número de participantes: 4
        if(listaParticipantes.size() < 4){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaEmparejamientos);
        }
        //Si la lista de participantes es impar, añadimos un participante más como ronda libre.
        if(listaParticipantes.size() % 2 > 0){
            listaParticipantes.add(-1);
        }
        boolean nuevoPar = true;
        int indiceActual = 0;
        for (Integer participante : listaParticipantes) {
            String jugador = findJugador(participante).getNombre();
            Emparejamiento emp;
            if(nuevoPar){
                emp = new Emparejamiento();
                emp.nuevoJugador(jugador);
                listaEmparejamientos.add(emp);
                nuevoPar = false;
            } else {
                emp = listaEmparejamientos.get(indiceActual++);
                emp.nuevoJugador(jugador);
                nuevoPar = true;
            }         
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaEmparejamientos);
    }
    //Encuentra Jugador. Si no existe, devuelve "Ronda Libre"
    private Jugador findJugador(int id){
        return jugadorRepository.findById(id).orElse(new Jugador("Ronda Libre"));
    }
    public ResponseEntity<Participacion> nuevoParticipante(@PathVariable int id, @Valid @RequestBody Jugador entity) {
        Participacion participacion = partService.nuevoParticipante(id,entity);
        return ResponseEntity.status(HttpStatus.OK).body(participacion);
    }


}
