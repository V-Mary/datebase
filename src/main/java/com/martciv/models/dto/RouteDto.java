package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {
    private Integer id;
    private String from;
    private String to;
}
