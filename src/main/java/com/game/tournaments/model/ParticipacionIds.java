package com.game.tournaments.model;

public class ParticipacionIds {


    private int idJugador;
    private int idTorneo;

    public ParticipacionIds(){}

    //Constructor con Ids
    public ParticipacionIds(int id_jugador, int id_torneo){
        this.idJugador = id_jugador;
        this.idTorneo = id_torneo;
    }
    
    public void setIdJugador(int idJugador){
        this.idJugador = idJugador;
    }
    
    public int getIdJugador(){
        return this.idJugador;
    }
    
    public void setIdTorneo(int idTorneo){
        this.idTorneo = idTorneo;
    }

    public int getIdTorneo(){
        return this.idTorneo;
    }
}
