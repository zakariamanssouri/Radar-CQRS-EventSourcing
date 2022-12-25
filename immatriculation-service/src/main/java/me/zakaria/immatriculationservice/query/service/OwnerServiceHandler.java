package me.zakaria.immatriculationservice.query.service;


import lombok.AllArgsConstructor;
import me.zakaria.commonapi.events.OwnerCreatedEvent;
import me.zakaria.commonapi.events.VehiculeCreatedEvent;
import me.zakaria.commonapi.queries.GetAllOwners;
import me.zakaria.commonapi.queries.GetAllRadarsQuery;
import me.zakaria.commonapi.queries.GetOwnerQuery;
import me.zakaria.commonapi.queries.GetRadarQuery;
import me.zakaria.immatriculationservice.query.entities.Owner;
import me.zakaria.immatriculationservice.query.entities.Vehicule;
import me.zakaria.immatriculationservice.query.repositories.OwnerRepository;
import me.zakaria.immatriculationservice.query.repositories.VehiculeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceHandler {
    private OwnerRepository ownerRepository;


    @EventHandler
    public void on(OwnerCreatedEvent event){
        Owner owner = new Owner();
        owner.setId(event.getId());
        owner.setNom(event.getNom());
        owner.setEmail(event.getEmail());
        owner.setDateNaissance(event.getDateNaissance());
        ownerRepository.save(owner);

    }

    @QueryHandler
    public List<Owner> on(GetAllOwners query) {
        return ownerRepository.findAll();
    }

    @QueryHandler
    public Owner on(GetOwnerQuery query){
        return ownerRepository.findById(query.getId()).get();
    }
}
