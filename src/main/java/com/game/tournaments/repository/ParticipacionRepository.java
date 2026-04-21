package com.game.tournaments.repository;

import java.util.List;

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

    @NativeQuery("SELECT id_jugador FROM Participaciones WHERE id_torneo = ?1 ORDER BY RAND()")
    public List<Integer> getParticipaciones(int id);

    //Tomamos la lista de jugadores inscritos en orden aleatorio
    @NativeQuery("SELECT * FROM Participaciones WHERE id_torneo = ?1 ORDER BY RAND()")
    //@NativeQuery("SELECT Participaciones.id_torneo, Jugadores.nombre, Jugadores.id_jugador " +
    //"FROM Participaciones INNER JOIN Jugadores ON Participaciones.id_jugador = Jugadores.id_jugador")
    public List<Jugador> getJugadores(int id);
}
