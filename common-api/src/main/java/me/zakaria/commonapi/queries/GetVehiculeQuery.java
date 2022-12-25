package me.zakaria.commonapi.queries;

import lombok.Data;

@Data
public class GetVehiculeQuery {
    private String id;

    public GetVehiculeQuery(String id) {
        this.id = id;
    }
}
