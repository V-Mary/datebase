package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private Integer age;
    private Integer ordered_tickets;
}
