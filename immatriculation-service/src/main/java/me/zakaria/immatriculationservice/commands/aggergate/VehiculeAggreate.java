package me.zakaria.immatriculationservice.commands.aggergate;

import lombok.Getter;
import me.zakaria.commonapi.commands.CreateVehiculeCommand;
import me.zakaria.commonapi.events.VehiculeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class VehiculeAggreate {

    @AggregateIdentifier
    private String id;
    private String immatriculation;
    private String marque;
    private int puissance;
    private String modele;
    private String owner;

    public VehiculeAggreate() {
    }

    @CommandHandler
    public VehiculeAggreate(CreateVehiculeCommand command) {
        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                command.getId(),
                command.getImmatriculation(),
                command.getMarque(),
                command.getPuissance(),
                command.getModele(),
                command.getOwner()
        ));
    }

    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event) {
        this.id = event.getId();
        this.immatriculation = event.getImmatriculation();
        this.marque = event.getMarque();
        this.puissance = event.getPuissance();
        this.modele = event.getModele();
        this.owner = event.getOwner();
    }
}
