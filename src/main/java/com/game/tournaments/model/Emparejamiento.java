package com.game.tournaments.model;

import java.util.List;
import java.util.ArrayList;

public class Emparejamiento {
    private List<String> jugadores;
    public Emparejamiento(){
        this.jugadores = new ArrayList<>();
    }
    public boolean nuevoJugador(String jugador){
        return this.jugadores.add(jugador);
    }
    public void setJugadores(List<String> jugadores){
        this.jugadores = jugadores;
    }
    
    public List<String> getJugadores(){
        return jugadores;
    }
}