package me.zakaria.immatriculationservice.commands.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.commands.CreateOwnerCommand;
import me.zakaria.commonapi.commands.CreateRadarCommand;
import me.zakaria.commonapi.dtos.CreateOwnerRequestDTO;
import me.zakaria.commonapi.dtos.CreateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
@AllArgsConstructor
@RequestMapping("/owners")
public class OwnerCommandController {
    private CommandGateway commandGateway;


    @PostMapping("/create")
    public CompletableFuture<String> createRadar(@RequestBody CreateOwnerRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateOwnerCommand(
                UUID.randomUUID().toString(),
                requestDTO.getNom(),
                requestDTO.getDateNaissance(),
                requestDTO.getEmail()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), null, 500);
        return responseEntity;
    }

}
