package com.game.tournaments.service;

import org.springframework.stereotype.Service;
import com.game.tournaments.model.Torneo;
import com.game.tournaments.repository.TorneosRepository;

import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService{

    private final TorneosRepository repository;
    public TorneoServiceImpl(TorneosRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Torneo> getAllTorneos(){
        return repository.findAll();
    }

    @Override
    public Torneo creaTorneo(String nombreTorneo, String tipoTorneo){
        Torneo torneo = repository.save(new Torneo(nombreTorneo,tipoTorneo));
        return torneo;
    }

    @Override
    public Torneo getTorneoById(Long id){
        return null;
    }
    @Override
    public List<Torneo> getTorneoByTipo(String tipoTorneo){
        return null;
    }
    @Override
    public Torneo getTorneoByName(String name){
        return null;
    }
}
