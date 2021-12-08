package com.martciv.models.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "insurance")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "days", nullable = false)
    private Integer days;

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", days=" + days +
                '}';
    }
}
