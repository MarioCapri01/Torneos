package com.game.tournaments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.tournaments.model.Torneo;

public interface TorneosRepository extends JpaRepository<Torneo, Long> {
    public List<Torneo> getTorneosByTipoTorneo(String tipo);
    public Torneo getTorneoByNombreTorneo(String nombre);
}
