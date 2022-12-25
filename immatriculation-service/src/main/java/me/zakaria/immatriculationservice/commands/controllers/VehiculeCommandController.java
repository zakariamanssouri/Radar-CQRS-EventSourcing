package me.zakaria.immatriculationservice.commands.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.commands.CreateRadarCommand;
import me.zakaria.commonapi.commands.CreateVehiculeCommand;
import me.zakaria.commonapi.dtos.CreateRadarRequestDTO;
import me.zakaria.commonapi.dtos.CreateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeCommandController {
    private CommandGateway commandGateway;


    @PostMapping("/create")
    public CompletableFuture<String> createVehicule(@RequestBody CreateVehiculeRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateVehiculeCommand(
                UUID.randomUUID().toString(),
                requestDTO.getImmatriculation(),
                requestDTO.getMarque(),
                requestDTO.getPuissance(),
                requestDTO.getModele(),
                requestDTO.getOwnerId()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), null, 500);
        return responseEntity;
    }

}
