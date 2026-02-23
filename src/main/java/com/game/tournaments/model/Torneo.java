package com.game.tournaments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "torneos")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_torneo")
    private String nombreTorneo;

    @Column(name = "tipo_torneo")
    private String tipoTorneo;

    public Torneo(){
        
    }

    public void setNombreTorneo(String nombreTorneo){
        this.nombreTorneo = nombreTorneo;
    }
    public String getNombreTorneo(){
        return nombreTorneo;
    }
    public void setTipoTorneo(String tipoTorneo){
        this.tipoTorneo = tipoTorneo;
    }
    public String getTipoTorneo(){
        return tipoTorneo;
    }
}
