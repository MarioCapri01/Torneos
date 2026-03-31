package com.game.tournaments.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "torneos")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_torneo")
    private int id_torneo;

    @NotBlank(message = "El Nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre_torneo")
    private String nombreTorneo;

    @NotBlank(message = "El Tipo es obligatorio")
    @Size(min = 3, max = 100, message = "El tipo debe tener entre 3 y 100 caracteres")
    @Column(name = "tipo_torneo")
    private String tipoTorneo;

    
    @OneToMany(mappedBy = "torneo")
    private List<Participacion> participaciones;

    public Torneo(){}

    public Torneo(String nombreTorneo, String tipoTorneo){
        this.nombreTorneo = nombreTorneo;
        this.tipoTorneo = tipoTorneo;
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
