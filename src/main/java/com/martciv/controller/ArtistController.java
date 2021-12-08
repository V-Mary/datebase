package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.ArtistConverter;
import com.martciv.models.domain.Artist;
import com.martciv.models.dto.ArtistDto;
import com.martciv.service.ArtistService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/artist")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDto>> getArtistList() {
        List<ArtistDto> responseArtistDtoList = new ArrayList<>();
        for (Artist artist: artistService.getAll()) {
            responseArtistDtoList.add(ArtistConverter.toDTO(artist));
        }
        return new ResponseEntity<>(responseArtistDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArtistDto> getArtist(@PathVariable Integer id) {
        try {
            Artist searchedArtist = artistService.getById(id);
            return new ResponseEntity<>(ArtistConverter.toDTO(searchedArtist), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ArtistDto> postArtist(@RequestBody ArtistDto artistDto) {
        Artist createdArtist = Artist.builder()
                .name(artistDto.getName())
                .build();
        Artist responseArtist = artistService.create(createdArtist);
        return new ResponseEntity<>(ArtistConverter.toDTO(responseArtist), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ArtistDto> putArtist(@RequestBody ArtistDto artistDto, @PathVariable Integer id) {
        try {
            Artist updatedArtistValues = Artist.builder()
                    .name(artistDto.getName())
                    .build();
            artistService.updateById(updatedArtistValues, id);
            artistDto.setId(id);
            return new ResponseEntity<>(artistDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ArtistDto> deleteArtist(@PathVariable Integer id) {
        try {
            artistService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
