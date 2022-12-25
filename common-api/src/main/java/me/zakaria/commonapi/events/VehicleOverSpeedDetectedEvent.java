package me.zakaria.commonapi.events;

import lombok.Getter;
import me.zakaria.commonapi.dtos.OverSpeedRequestDTO;

public class VehicleOverSpeedDetectedEvent extends BaseEvent<String> {

    @Getter
    private OverSpeedRequestDTO speed;

    public VehicleOverSpeedDetectedEvent(String id, OverSpeedRequestDTO speed) {
        super(id);
        this.speed = speed;
    }


}
