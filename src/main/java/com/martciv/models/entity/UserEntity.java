package com.martciv.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "tickets", catalog = "")
public class UserEntity {
    private Integer id;
    private String name;
    private Integer age;
    private Integer orderedTickets;

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
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "ordered_tickets")
    public Integer getOrderedTickets() {
        return orderedTickets;
    }

    public void setOrderedTickets(Integer orderedTickets) {
        this.orderedTickets = orderedTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(orderedTickets, that.orderedTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, orderedTickets);
    }
}
