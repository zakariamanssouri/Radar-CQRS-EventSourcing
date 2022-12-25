package me.zakaria.immatriculationservice.commands.aggergate;

import lombok.Getter;
import me.zakaria.commonapi.commands.CreateOwnerCommand;
import me.zakaria.commonapi.events.OwnerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class OwnerAggregate {

    @AggregateIdentifier
    private String id;
    private String nom;
    private Date dateNaissance;
    private String email;

    public OwnerAggregate() {
    }

    @CommandHandler
    public OwnerAggregate(CreateOwnerCommand command) {
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getDateNaissance(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public void on(OwnerCreatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.dateNaissance = event.getDateNaissance();
        this.email = event.getEmail();
    }

}
