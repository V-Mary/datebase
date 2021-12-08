package com.martciv.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistDto {
    private Integer id;
    private String name;
}
