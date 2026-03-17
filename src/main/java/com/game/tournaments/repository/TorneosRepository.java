package com.game.tournaments.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.tournaments.model.Torneo;
@Repository
public interface TorneosRepository extends JpaRepository<Torneo, Long> {
    public List<Torneo> getTorneosByTipoTorneo(String tipo);
    public Torneo getTorneoByNombreTorneo(String nombre);
    /*@Query()
    public List<Torneo> getAllTorneos();*/
}
