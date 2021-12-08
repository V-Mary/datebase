package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceDto {
    private Integer id;
    private String name;
    private Integer price;
    private Integer days;
}
