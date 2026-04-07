package com.game.tournaments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.game.tournaments.model.Jugador;
import com.game.tournaments.model.Participacion;
import com.game.tournaments.model.Torneo;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participacion, Integer> {
    @NativeQuery("SELECT * FROM Jugadores WHERE id_jugador = ?1")
    public Jugador getJugadorById(int id);

    @NativeQuery("SELECT * FROM Torneos WHERE id_torneo = ?1")
    public Torneo getTorneoById(int id);
}
