package com.game.tournaments.service;

import com.game.tournaments.model.Jugador;
import com.game.tournaments.model.Participacion;
import com.game.tournaments.model.Torneo;
import com.game.tournaments.repository.ParticipacionRepository;

import org.springframework.stereotype.Service;

@Service
public class ParticipacionServiceImpl implements ParticipacionService{
    private final ParticipacionRepository repository;
    public ParticipacionServiceImpl(ParticipacionRepository repository){
        this.repository = repository;
    }

    @Override
    public Participacion creaParticipacion(Torneo torneo, Jugador jugador){
        return repository.save(new Participacion(jugador, torneo));
    }

    @Override
    public Participacion nuevoParticipante(int id, Jugador jugador){
        Participacion part = repository.findById(id).get();
        //part.getJugador().add(jugador);
        return part;
    }

    @Override
    public Jugador getJugadorById(int id){
        return repository.getJugadorById(id);
    }
    @Override
    public Torneo getTorneoById(int id){
        return repository.getTorneoById(id);
    }


}
