package me.zakaria.radarservice.commands.aggregates;


import lombok.extern.slf4j.Slf4j;
import me.zakaria.commonapi.commands.CreateRadarCommand;
import me.zakaria.commonapi.commands.NewVehicleOverSpeedDetectionCommand;
import me.zakaria.commonapi.commands.UpdateRadarCommand;
import me.zakaria.commonapi.events.RadarCreatedEvent;
import me.zakaria.commonapi.events.RadarUpdatedEvent;
import me.zakaria.commonapi.events.VehicleOverSpeedDetectedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@Slf4j
public class RadarAggregate {

    @AggregateIdentifier
    private String id;
    private double maxSpeed;
    private String longitude;
    private String latitude;


    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event) {
        this.id = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
    }

    @CommandHandler
    public void on(NewVehicleOverSpeedDetectionCommand command) {
        log.info("New vehicle over speed detection command received");
        command.getPayload().setOverSpeedId(UUID.randomUUID().toString());
        command.getPayload().setRadarMaxSpeed(this.maxSpeed);
        command.getPayload().setRadarLatitude(this.latitude);
        command.getPayload().setRadarLongitude(this.longitude);

        AggregateLifecycle.apply(new VehicleOverSpeedDetectedEvent(
                command.getId(),command.getPayload()
        ));

    }

    @CommandHandler
    public void on(UpdateRadarCommand command) {
        AggregateLifecycle.apply(new RadarUpdatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent event) {
        this.id = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
    }


}
