package com.martciv.models.converter;
import com.martciv.models.domain.Route;
import com.martciv.models.dto.RouteDto;
public class RouteConverter {
    public static RouteDto toDTO(Route route) {
        RouteDto convertedDto = RouteDto.builder()
                .id(route.getId())
                .from(route.getFrom())
                .to(route.getTo())
                .build();
        return convertedDto;
    }
}
