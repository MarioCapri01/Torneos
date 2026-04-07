package com.game.tournaments.service;

import com.game.tournaments.model.Participacion;
import com.game.tournaments.model.Torneo;
import com.game.tournaments.model.Jugador;

public interface ParticipacionService {
    public Participacion creaParticipacion(Torneo torneo, Jugador jugador);
    public Participacion nuevoParticipante(int id, Jugador jugador);
    public Jugador getJugadorById(int idJugador);
    public Torneo getTorneoById(int idTorneo);
}
