package me.zakaria.commonapi.commands;

import lombok.Getter;

public class CreateVehiculeCommand extends BaseCommand<String>{
    @Getter private String immatriculation;
    @Getter private String marque;
    @Getter private int puissance;
    @Getter private String modele;
    @Getter private String owner;

    public CreateVehiculeCommand(String id, String immatriculation, String marque, int puissance, String modele, String owner) {
        super(id);
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.puissance = puissance;
        this.modele = modele;
        this.owner = owner;
    }
}
