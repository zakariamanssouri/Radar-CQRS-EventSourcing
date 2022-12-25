package me.zakaria.radarservice.commands.controllers;

import lombok.AllArgsConstructor;
import me.zakaria.commonapi.commands.CreateRadarCommand;
import me.zakaria.commonapi.commands.NewVehicleOverSpeedDetectionCommand;
import me.zakaria.commonapi.commands.UpdateRadarCommand;
import me.zakaria.commonapi.dtos.OverSpeedRequestDTO;
import me.zakaria.commonapi.dtos.CreateRadarRequestDTO;
import me.zakaria.commonapi.dtos.UpdateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/radars")
@AllArgsConstructor
public class RadarCommandController {
    private CommandGateway commandGateway;


    @PostMapping("/create")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                requestDTO.getMaxSpeed(),
                requestDTO.getLongitude(),
                requestDTO.getLatitude()
        ));
        return commandResponse;
    }

    @PostMapping("/overSpeed")
    public CompletableFuture<String> newOverSpeed(@RequestBody OverSpeedRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new NewVehicleOverSpeedDetectionCommand(
                requestDTO.getRadarId(),
                requestDTO

        ));
        return commandResponse;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadarRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateRadarCommand(
                requestDTO.getId(),
                requestDTO.getMaxSpeed(),
                requestDTO.getLongitude(),
                requestDTO.getLatitude()

        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), null, 500);
        return responseEntity;
    }

}
