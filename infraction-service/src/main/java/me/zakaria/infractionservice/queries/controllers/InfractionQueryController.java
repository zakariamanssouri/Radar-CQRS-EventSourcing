package me.zakaria.infractionservice.queries.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.queries.GetAllVehicules;
import me.zakaria.commonapi.queries.GetVehiculeQuery;
import me.zakaria.commonapi.queries.infractions.GetAllInfractions;
import me.zakaria.commonapi.queries.infractions.GetInfractionQuery;
import me.zakaria.infractionservice.queries.entities.Infraction;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/infractions")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class InfractionQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    private List<Infraction> vehiculeList(){
        return queryGateway.query(new GetAllInfractions(), ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }
    @GetMapping("/{id]")
    private Infraction getInfraction(@PathVariable String id){
        return queryGateway.query(new GetInfractionQuery(id), ResponseTypes.instanceOf(Infraction.class)).join();
    }


}
