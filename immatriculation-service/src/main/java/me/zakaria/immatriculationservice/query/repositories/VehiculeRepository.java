package me.zakaria.immatriculationservice.query.repositories;

import me.zakaria.immatriculationservice.query.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,String> {

}
