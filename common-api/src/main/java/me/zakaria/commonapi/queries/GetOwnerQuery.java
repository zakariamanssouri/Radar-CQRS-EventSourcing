package me.zakaria.commonapi.queries;

import lombok.Data;

@Data
public class GetOwnerQuery {

    private String id;

    public GetOwnerQuery(String id) {
        this.id = id;
    }
}
