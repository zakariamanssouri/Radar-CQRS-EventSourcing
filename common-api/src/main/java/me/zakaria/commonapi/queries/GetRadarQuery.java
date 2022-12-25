package me.zakaria.commonapi.queries;

import lombok.Data;

@Data
public class GetRadarQuery {
    private String id;

    public GetRadarQuery(String id) {
        this.id = id;
    }
}
