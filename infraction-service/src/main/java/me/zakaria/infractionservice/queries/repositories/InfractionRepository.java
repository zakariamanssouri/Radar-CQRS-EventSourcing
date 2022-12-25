package me.zakaria.infractionservice.queries.repositories;

import me.zakaria.infractionservice.queries.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, String> {

}
