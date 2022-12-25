package me.zakaria.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfractionRequestDTO {
    private Date date;
    private String radarId;
    private String immatriculation;
    private double speed;
    private double maxSpeed;
    private Long amount;
}
