package com.martciv.models.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto {
    private Integer id;
    private String type;
    private Integer all_places;
    private Integer free_places;
    private Integer route_id;
    private Integer artist_id;
}
