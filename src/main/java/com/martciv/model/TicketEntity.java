package com.martciv.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TicketEntity {
    private int id;
    private String name;
    private int place;
    private int price;
    private int user_id;
    private int delivery_id;
    private int event_id;
    private int insurance_id;

    public TicketEntity(Integer id, String name, int place, int price, int user_id, int delivery_id,
                        int event_id, int insurance_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.place = place;
        this.user_id = user_id;
        this.delivery_id = delivery_id;
        this.event_id = event_id;
        this.insurance_id = insurance_id;
    }

    public TicketEntity(String name,int place, int price, int user_id,int delivery_id,
                        int event_id,int insurance_id) {
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", place='" + place + '\'' +
                ", user_id='" + user_id + '\'' +
                ", delivery_id='" + delivery_id + '\'' +
                ", event_id='" + event_id + '\'' +
                ", insurance_id='" + insurance_id + '\'' +
                '}';
    }
}
