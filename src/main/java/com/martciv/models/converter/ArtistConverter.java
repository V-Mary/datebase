package com.martciv.models.converter;

import com.martciv.models.domain.Artist;
import com.martciv.models.dto.ArtistDto;

public class ArtistConverter {
    public static ArtistDto toDTO(Artist artist) {
        ArtistDto convertedDto = ArtistDto.builder()
                .id(artist.getId())
                .name(artist.getName())
                .build();
        return convertedDto;
    }
}
