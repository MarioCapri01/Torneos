package com.game.tournaments.service;

import org.springframework.stereotype.Service;
import com.game.tournaments.model.Torneo;
import java.util.List;

@Service
public interface TorneoService {

    public Torneo creaTorneo(Long id, String nombreTorneo, String tipoTorneo);
    public Torneo getTorneoById(Long id);
    public List<Torneo> getTorneoByTipo(String tipoTorneo);
    public Torneo getTorneoByName(String name);
}
