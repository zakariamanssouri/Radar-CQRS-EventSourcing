package me.zakaria.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRadarRequestDTO {

    private String id;
    private double maxSpeed;
    private String longitude;
    private String latitude;

}
