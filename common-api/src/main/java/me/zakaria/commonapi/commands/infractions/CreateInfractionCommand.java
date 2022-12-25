package me.zakaria.commonapi.commands.infractions;

import lombok.Getter;
import me.zakaria.commonapi.commands.BaseCommand;

import java.util.Date;

public class CreateInfractionCommand extends BaseCommand<String> {



    @Getter
    private Date date;
    @Getter
    private String radarId;
    @Getter
    private String immatriculation;
    @Getter
    private double speed;
    @Getter
    private double maxSpeed;
    @Getter
    private Long amount;


    public CreateInfractionCommand(String id, Date date, String radarId, String immatriculation, double speed, double maxSpeed, Long amount) {
        super(id);
        this.date = date;
        this.radarId = radarId;
        this.immatriculation = immatriculation;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.amount = amount;
    }
}
