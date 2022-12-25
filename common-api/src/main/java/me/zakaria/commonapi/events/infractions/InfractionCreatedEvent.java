package me.zakaria.commonapi.events.infractions;

import lombok.Data;
import lombok.Getter;
import me.zakaria.commonapi.events.BaseEvent;

import java.util.Date;

@Data
public class InfractionCreatedEvent extends BaseEvent<String> {
    private Date date;
    private String radarId;
    private String immatriculation;
    private double speed;
    private double maxSpeed;
    private Long amount;

    public InfractionCreatedEvent(String id, Date date, String radarId, String immatriculation, double speed, double maxSpeed, Long amount) {
        super(id);
        this.date = date;
        this.radarId = radarId;
        this.immatriculation = immatriculation;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.amount = amount;
    }
}
