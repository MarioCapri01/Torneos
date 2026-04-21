package com.game.tournaments.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private int id_jugador;

    @NotBlank(message = "El Nombre es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "jugador")
    private List<Participacion> participaciones;

    private int id_torneo;
    public Jugador(){
    }

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public Jugador(String nombre, int id_torneo){
        this.nombre = nombre;
        this.id_torneo = id_jugador;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setIdTorneo(int id_torneo){
        this.id_torneo = id_torneo;
    }
    public int getIdTorneo(){
        return this.id_torneo;
    }

}
