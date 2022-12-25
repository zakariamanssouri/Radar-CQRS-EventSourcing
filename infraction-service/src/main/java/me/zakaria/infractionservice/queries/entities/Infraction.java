package me.zakaria.infractionservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Infraction {
    @Id
    private String id;
    private Date date;
    private String radarId;
    private String immatriculation;
    private double speed;
    private double maxSpeed;
    private Long amount;
}
