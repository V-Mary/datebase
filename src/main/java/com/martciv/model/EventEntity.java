package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class EventEntity {
    private int id;
    private String type;
    private int all_places;
    private int free_places;
    private int city_id;
    private int street_id;
    private int artist_id;
    private int route_id;

    public EventEntity(int id, String type, int all_places, int free_places,
                       int city_id, int street_id, int artist_id, int route_id) {
        this.id = id;
        this.type = type;
        this.all_places = all_places;
        this.free_places = free_places;
        this.city_id = city_id;
        this.street_id = street_id;
        this.artist_id = artist_id;
        this.route_id = route_id;
    }

    public EventEntity(String type, int all_places, int free_places,
                       int city_id, int street_id, int artist_id, int route_id) {
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", type='" + type  +
                ", all_places='" + all_places  +
                ", free_places='" + free_places  +
                ", city_id='" + city_id  +
                ", street_id='" + street_id  +
                ", artist_id='" + artist_id  +
                ", route_id='" + route_id  +
                '}';
    }
}
