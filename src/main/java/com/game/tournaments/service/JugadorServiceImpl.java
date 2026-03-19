package com.game.tournaments.service;

import org.springframework.stereotype.Service;
import com.game.tournaments.repository.JugadorRepository;
import com.game.tournaments.model.Jugador;
import java.util.List;
@Service
public class JugadorServiceImpl implements JugadorService{

    private final JugadorRepository repository;
    public JugadorServiceImpl(JugadorRepository repository){
        this.repository = repository;
    }
    @Override
    public Jugador creaJugador(String nombre){
        Jugador jugador = repository.save(new Jugador(nombre));
        return jugador;
    };
    @Override
    public Jugador getJugadorById(Long id){
        return null;
    };
    public List<Jugador> getAllJugadores(){
        return repository.findAll();
    };
}
