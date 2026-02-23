package com.game.tournaments.service;

import org.springframework.stereotype.Service;
import com.game.tournaments.model.Torneo;
import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService{

    @Override
    public Torneo creaTorneo(Long id, String nombreTorneo, String tipoTorneo){
        return null;
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
