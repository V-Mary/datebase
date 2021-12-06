package com.martciv.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "tickets", catalog = "")
@IdClass(TicketEntityPK.class)
public class TicketEntity {
    private Integer id;
    private String name;
    private Integer place;
    private Integer price;
    private Integer eventId;
    private Integer insuranceId;
    private Integer userId;
    private Integer deliveryId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "place")
    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Id
    @Column(name = "event_id")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "insurance_id")
    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "delivery_id")
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(place, that.place) && Objects.equals(price, that.price) && Objects.equals(eventId, that.eventId) && Objects.equals(insuranceId, that.insuranceId) && Objects.equals(userId, that.userId) && Objects.equals(deliveryId, that.deliveryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, price, eventId, insuranceId, userId, deliveryId);
    }
}
