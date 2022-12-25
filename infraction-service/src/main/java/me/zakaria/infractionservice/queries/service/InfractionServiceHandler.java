package me.zakaria.infractionservice.queries.service;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.events.infractions.InfractionCreatedEvent;
import me.zakaria.commonapi.queries.GetAllOwners;
import me.zakaria.commonapi.queries.GetOwnerQuery;
import me.zakaria.commonapi.queries.infractions.GetAllInfractions;
import me.zakaria.commonapi.queries.infractions.GetInfractionQuery;
import me.zakaria.infractionservice.queries.entities.Infraction;
import me.zakaria.infractionservice.queries.repositories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InfractionServiceHandler {
    private InfractionRepository infractionRepository;


    @EventHandler
    public void on(InfractionCreatedEvent event){
        Infraction infraction = new Infraction();
        infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setRadarId(event.getRadarId());
        infraction.setImmatriculation(event.getImmatriculation());
        infraction.setSpeed(event.getSpeed());
        infraction.setMaxSpeed(event.getMaxSpeed());
        infraction.setAmount(event.getAmount());
        infractionRepository.save(infraction);
    }

    @QueryHandler
    public List<Infraction> on(GetAllInfractions query) {
        return infractionRepository.findAll();
    }

    @QueryHandler
    public Infraction on(GetInfractionQuery query){
        return infractionRepository.findById(query.getId()).get();
    }
}
