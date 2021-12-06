package com.martciv.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "tickets", catalog = "")
@IdClass(EventEntityPK.class)
public class EventEntity {
    private Integer id;
    private String type;
    private Integer allPlaces;
    private Integer freePlaces;
    private Integer routeId;
    private Integer artistId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "all_places")
    public Integer getAllPlaces() {
        return allPlaces;
    }

    public void setAllPlaces(Integer allPlaces) {
        this.allPlaces = allPlaces;
    }

    @Basic
    @Column(name = "free_places")
    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Id
    @Column(name = "route_id")
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "artist_id")
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(allPlaces, that.allPlaces) && Objects.equals(freePlaces, that.freePlaces) && Objects.equals(routeId, that.routeId) && Objects.equals(artistId, that.artistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, allPlaces, freePlaces, routeId, artistId);
    }
}
