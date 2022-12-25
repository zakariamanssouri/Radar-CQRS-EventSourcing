package me.zakaria.immatriculationservice.query.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.queries.GetAllOwners;
import me.zakaria.commonapi.queries.GetAllVehicules;
import me.zakaria.commonapi.queries.GetOwnerQuery;
import me.zakaria.commonapi.queries.GetVehiculeQuery;
import me.zakaria.immatriculationservice.query.entities.Owner;
import me.zakaria.immatriculationservice.query.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/vehicule")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class VehiculeQueryController {

    private QueryGateway queryGateway;


    @GetMapping("/all")
    private List<Vehicule> vehiculeList(){
        return queryGateway.query(new GetAllVehicules(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
    }
    @GetMapping("/{id]")
    private Vehicule getVehicule(@PathVariable String id){
        return queryGateway.query(new GetVehiculeQuery(id), ResponseTypes.instanceOf(Vehicule.class)).join();
    }
}
