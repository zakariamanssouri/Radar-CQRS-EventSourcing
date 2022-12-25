package me.zakaria.immatriculationservice.query.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.queries.GetAllOwners;
import me.zakaria.commonapi.queries.GetAllRadarsQuery;
import me.zakaria.commonapi.queries.GetOwnerQuery;
import me.zakaria.immatriculationservice.query.entities.Owner;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/owner")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class OwnerQueryController {

    private QueryGateway queryGateway;


    @GetMapping("/all")
    private List<Owner> ownersList(){
        return queryGateway.query(new GetAllOwners(), ResponseTypes.multipleInstancesOf(Owner.class)).join();
    }
    @GetMapping("/{id]")
    private Owner getOwner(@PathVariable String id){
        return queryGateway.query(new GetOwnerQuery(id), ResponseTypes.instanceOf(Owner.class)).join();
    }

}
