package com.martciv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceEntity {
    private int id;
    private String name;
    private int price;
    private int days;

    public InsuranceEntity(int id, String name, int price, int days) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.days = days;
    }

    public InsuranceEntity(String name, int price, int days) {
    }

    @Override
    public String toString() {
        return "InsuranceEntity{" +
                "id=" + id +
                ", name='" + name  +
                ", price='" + price  +
                ", days='" + days  +
                '}';
    }
}
