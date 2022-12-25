package me.zakaria.commonapi.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {



    @Getter
    private double maxSpeed;
    @Getter
    private String longitude;
    @Getter
    private String latitude;


    public CreateRadarCommand(String id, double maxSpeed, String longitude, String latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
