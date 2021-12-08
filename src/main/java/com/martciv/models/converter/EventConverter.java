package com.martciv.models.converter;
import com.martciv.models.domain.Event;
import com.martciv.models.dto.EventDto;
public class EventConverter {
    public static EventDto toDTO(Event event) {
        EventDto convertedDto = EventDto.builder()
                .id(event.getId())
                .type(event.getType())
                .all_places(event.getAll_places())
                .free_places(event.getFree_places())
                .route_id(event.getRoute().getId())
                .artist_id(event.getArtist().getId())
                .build();
        return convertedDto;
    }
}
