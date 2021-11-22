package com.martciv.model;

import com.martciv.DAO.GeneralDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private int id;
    private String name;
    private int age;
    private int ordered_tickets;

    public UserEntity(int id, String name, Integer age, int ordered_tickets) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ordered_tickets = ordered_tickets;
    }

    public UserEntity( String name, Integer age, int ordered_tickets) {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", ordered_tickets='" + ordered_tickets + '\'' +
                '}';
    }
}
