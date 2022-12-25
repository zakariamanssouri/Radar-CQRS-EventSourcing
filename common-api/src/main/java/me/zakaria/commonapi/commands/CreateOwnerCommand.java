package me.zakaria.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateOwnerCommand extends BaseCommand<String>{
    @Getter private String nom;
    @Getter private Date dateNaissance;
    @Getter private String email;


    public CreateOwnerCommand(String id, String nom, Date dateNaissance, String email) {
        super(id);
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }
}
