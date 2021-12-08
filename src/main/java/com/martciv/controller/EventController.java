package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.EventConverter;
import com.martciv.models.domain.Event;
import com.martciv.models.dto.EventDto;
import com.martciv.service.EventService;
import com.martciv.service.RouteService;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/event")
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    RouteService routeService;


    @GetMapping
    public ResponseEntity<List<EventDto>> getEventList() {
        List<EventDto> responseEventDtoList = new ArrayList<>();
        for (Event event: eventService.getAll()) {
            responseEventDtoList.add(EventConverter.toDTO(event));
        }
        return new ResponseEntity<>(responseEventDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EventDto> getEvent(@PathVariable Integer id) {
        try {
            Event searchedEvent = eventService.getById(id);
            return new ResponseEntity<>(EventConverter.toDTO(searchedEvent), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EventDto> postEvent(@RequestBody EventDto eventDto) {
        Event createdEvent = Event.builder()
                .type(eventDto.getType())
                .all_places(eventDto.getAll_places())
                .free_places(eventDto.getFree_places())


                .build();
        Event responseEvent = eventService.create(createdEvent);
        return new ResponseEntity<>(EventConverter.toDTO(responseEvent), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EventDto> putEvent(@RequestBody EventDto eventDto, @PathVariable Integer id) {
        try {
            Event updatedEventValues = Event.builder()
                    .type(eventDto.getType())
                    .all_places(eventDto.getAll_places())
                    .free_places(eventDto.getFree_places())


                    .build();
            eventService.updateById(updatedEventValues, id);
            eventDto.setId(id);
            return new ResponseEntity<>(eventDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable Integer id) {
        try {
            eventService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
