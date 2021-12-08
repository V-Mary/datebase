package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryDto {
    private Integer id;
    private String city;
    private String street;
    private Integer number;
}
