package me.zakaria.commonapi.events;

import lombok.Getter;

public class RadarUpdatedEvent extends BaseEvent<String> {
    @Getter private double maxSpeed;
    @Getter private String longitude;
    @Getter private String latitude;

    public RadarUpdatedEvent(String id, double maxSpeed, String longitude, String latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
