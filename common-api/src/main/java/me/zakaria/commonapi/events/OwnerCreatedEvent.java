package me.zakaria.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class OwnerCreatedEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private Date dateNaissance;
    @Getter private String email;

    public OwnerCreatedEvent(String id, String nom, Date dateNaissance, String email) {
        super(id);
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }
}
