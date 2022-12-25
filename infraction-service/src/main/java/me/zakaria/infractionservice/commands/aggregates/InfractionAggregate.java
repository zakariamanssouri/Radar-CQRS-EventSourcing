package me.zakaria.infractionservice.commands.aggregates;

import lombok.extern.slf4j.Slf4j;
import me.zakaria.commonapi.commands.infractions.CreateInfractionCommand;
import me.zakaria.commonapi.events.infractions.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class InfractionAggregate {

    @AggregateIdentifier
    private String id;
    private Date date;
    private String radarId;
    private String immatriculation;
    private double speed;
    private double maxSpeed;
    private Long amount;

    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(),
                command.getDate(),
                command.getRadarId(),
                command.getImmatriculation(),
                command.getSpeed(),
                command.getMaxSpeed(),
                command.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.date = event.getDate();
        this.radarId = event.getRadarId();
        this.immatriculation = event.getImmatriculation();
        this.speed = event.getSpeed();
        this.maxSpeed = event.getMaxSpeed();
        this.amount = event.getAmount();
    }
}
