package me.zakaria.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverSpeedRequestDTO {
    private String radarId;
    private Date timestamp;
    private String overSpeedId;
    private String vehicleRegistrationNumber;
    private double vehicleSpeed;
    private double radarMaxSpeed;
    private String radarLongitude;
    private String radarLatitude;
}
