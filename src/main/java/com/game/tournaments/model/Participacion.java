package com.game.tournaments.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "participaciones")
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participacion")
    private int id_participacion;

    @ManyToOne
    @JoinColumn(name = "id_jugador")//, referencedColumnName = "id_jugador" )
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_torneo")//, referencedColumnName = "id_torneo")
    private Torneo torneo;

    public Participacion(){}

    public Participacion(Jugador jugador, Torneo torneo){
        this.jugador = jugador;
        this.torneo = torneo;
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }
    
    public void setTorneo(Torneo torneo){
        this.torneo = torneo;
    }

    public Torneo getTorneo(){
        return this.torneo;
    }
}
