package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityEntity {
    private Integer id;
    private String city;

    public CityEntity(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public CityEntity() {

    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
