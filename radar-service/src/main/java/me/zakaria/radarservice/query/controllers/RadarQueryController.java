package me.zakaria.radarservice.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zakaria.commonapi.queries.GetAllRadarsQuery;
import me.zakaria.commonapi.queries.GetRadarQuery;
import me.zakaria.radarservice.query.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/radar")
@AllArgsConstructor
@Slf4j
public class RadarQueryController {
    private QueryGateway queryGateway;


    @GetMapping("/all")
    private List<Radar> radarList(){
        return queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
    }

    @GetMapping("/{id}")
    private Radar radar(@PathVariable String id){
        return queryGateway.query(new GetRadarQuery(id), ResponseTypes.instanceOf(Radar.class)).join();
    }
}
