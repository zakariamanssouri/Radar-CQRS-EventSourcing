package me.zakaria.infractionservice.commands.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.commands.infractions.CreateInfractionCommand;
import me.zakaria.commonapi.dtos.CreateInfractionRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/infractions")
public class InfractionCommandController {
    private CommandGateway commandGateway;


    @PostMapping("/create")
    public CompletableFuture<String> createInfraction(@RequestBody CreateInfractionRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                requestDTO.getDate(),
                requestDTO.getRadarId(),
                requestDTO.getImmatriculation(),
                requestDTO.getSpeed(),
                requestDTO.getMaxSpeed(),
                requestDTO.getAmount()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), null, 500);
        return responseEntity;
    }
}
