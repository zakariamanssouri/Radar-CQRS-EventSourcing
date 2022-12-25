package me.zakaria.commonapi.queries.infractions;

public class GetInfractionQuery {
    private String id;

    public GetInfractionQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
