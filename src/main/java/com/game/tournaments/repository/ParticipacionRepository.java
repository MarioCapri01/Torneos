package com.game.tournaments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.game.tournaments.model.Participacion;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participacion, Integer> {
}
