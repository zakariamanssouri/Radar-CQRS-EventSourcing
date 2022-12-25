package me.zakaria.radarservice.query.repositories;

import me.zakaria.radarservice.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RadarRepository extends JpaRepository<Radar, String> {

}
