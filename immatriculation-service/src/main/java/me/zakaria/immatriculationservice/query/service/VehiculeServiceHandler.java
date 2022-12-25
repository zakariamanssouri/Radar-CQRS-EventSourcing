package me.zakaria.immatriculationservice.query.service;


import lombok.AllArgsConstructor;
import me.zakaria.commonapi.events.VehiculeCreatedEvent;
import me.zakaria.commonapi.queries.GetAllRadarsQuery;
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
public class VehiculeServiceHandler {
    private OwnerRepository ownerRepository;
    private VehiculeRepository vehiculeRepository;

    @EventHandler
    public void on(VehiculeCreatedEvent event){
        if(event.getOwner()!=null){
            Owner owner = ownerRepository.findById(event.getOwner()).get();
            Vehicule vehicule = new Vehicule();
            vehicule.setId(event.getId());
            vehicule.setImmatriculation(event.getImmatriculation());
            vehicule.setMarque(event.getMarque());
            vehicule.setModele(event.getModele());
            vehicule.setPuissance(event.getPuissance());
            vehicule.setOwner(owner);
            vehiculeRepository.save(vehicule);
        }
    }

    @QueryHandler
    public List<Vehicule> on(GetAllRadarsQuery query) {
        return vehiculeRepository.findAll();
    }

    @QueryHandler
    public Vehicule on(GetRadarQuery query){
        return vehiculeRepository.findById(query.getId()).get();
    }
}
