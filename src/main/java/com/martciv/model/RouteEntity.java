package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteEntity {
    private int id;
    private String from;
    private String to;

    public RouteEntity(Integer id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public RouteEntity(String from, String to) {
    }

    @Override
    public String toString() {
        return "RouteEntity{" +
                "id=" + id +
                ", from='" + from  +
                ", to='" + to  +
                '}';
    }

}
