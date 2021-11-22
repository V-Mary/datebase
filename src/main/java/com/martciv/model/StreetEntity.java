package com.martciv.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreetEntity {
    private Integer id;
    private String street;
    private int number;

    public StreetEntity(Integer id, String street,int number) {
        this.id = id;
        this.street = street;
        this.number = number;
    }

    public StreetEntity( String street,int number) {
    }

    @Override
    public String toString() {
        return "StreetEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
