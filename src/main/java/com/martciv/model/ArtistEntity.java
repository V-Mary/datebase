package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistEntity {
    private int id;
    private String name;

    public ArtistEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistEntity(String name) {
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", name='" + name  +
                '}';
    }
}
