package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {
    private Integer id;
    private String name;
    private Integer place;
    private Integer price;
    private Integer event_id;
    private Integer insurance_id;
    private Integer user_id;
    private Integer delivery_id;
}
