package com.game.tournaments.service;

import com.game.tournaments.model.Jugador;
import java.util.List;

public interface JugadorService {
    public Jugador creaJugador(String nombre);
    public Jugador getJugadorById(Long id);
    public List<Jugador> getAllJugadores();
}
