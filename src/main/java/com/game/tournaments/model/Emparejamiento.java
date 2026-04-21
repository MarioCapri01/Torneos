package com.game.tournaments.model;

import java.util.List;
import java.util.ArrayList;

public class Emparejamiento {
    private List<String> jugadores;
    private int maxNumJugadores;
    public Emparejamiento(){
        this.maxNumJugadores = 2;
        this.jugadores = new ArrayList<>();
    }
    public boolean nuevoJugador(String jugador){
        if(jugadores.size() < maxNumJugadores) {
            return this.jugadores.add(jugador);
        }
        return false;
    }
    public void setJugadores(List<String> jugadores){
        this.jugadores = jugadores;
    }
    
    public List<String> getJugadores(){
        return jugadores;
    }
}