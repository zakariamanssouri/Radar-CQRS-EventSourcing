package me.zakaria.commonapi.commands;

import lombok.Getter;
import me.zakaria.commonapi.dtos.OverSpeedRequestDTO;

public class NewVehicleOverSpeedDetectionCommand extends BaseCommand<String> {

    @Getter
    private OverSpeedRequestDTO payload;

    public NewVehicleOverSpeedDetectionCommand(String id, OverSpeedRequestDTO payload) {
        super(id);
        this.payload = payload;
    }
}
