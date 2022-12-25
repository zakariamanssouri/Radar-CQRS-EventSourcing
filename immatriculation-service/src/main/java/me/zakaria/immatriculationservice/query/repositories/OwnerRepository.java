package me.zakaria.immatriculationservice.query.repositories;

import me.zakaria.immatriculationservice.query.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {

}
