package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryEntity {
    private int id;
    private int city_id;
    private int street_id;

    public DeliveryEntity(int id, int city_id, int street_id) {
        this.id = id;
        this.city_id = city_id;
        this.street_id = street_id;
    }

    public DeliveryEntity(int city_id, int street_id) {
    }

    @Override
    public String toString() {
        return "DeliveryEntity{" +
                "id=" + id +
                ", city_id='" + city_id  +
                ", street_id='" + street_id  +
                '}';
    }

}
