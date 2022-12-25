package me.zakaria.radarservice.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zakaria.commonapi.events.RadarCreatedEvent;
import me.zakaria.commonapi.events.RadarUpdatedEvent;
import me.zakaria.commonapi.queries.GetAllRadarsQuery;
import me.zakaria.commonapi.queries.GetRadarQuery;
import me.zakaria.radarservice.query.entities.Radar;
import me.zakaria.radarservice.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarServiceHandler {
    private RadarRepository radarRepository;


    @EventHandler
    public void on(RadarCreatedEvent event) {
        log.info("Handling RadarCreatedEvent for aggregate id : "+event.getId());
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setMaxSpeed(event.getMaxSpeed());
        radarRepository.save(radar);
    }


    @EventHandler
    public void on(RadarUpdatedEvent event){
        log.info("Handling RadarUpdatedEvent for aggregate id : "+event.getId());
        Radar radar = radarRepository.findById(event.getId()).get();
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setMaxSpeed(event.getMaxSpeed());
        radarRepository.save(radar);
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query) {
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar on(GetRadarQuery query){
        return radarRepository.findById(query.getId()).get();
    }
}
