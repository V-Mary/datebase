package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.RouteConverter;
import com.martciv.models.domain.Route;
import com.martciv.models.dto.RouteDto;
import com.martciv.service.RouteService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteDto>> getRouteList() {
        List<RouteDto> responseRouteDtoList = new ArrayList<>();
        for (Route route: routeService.getAll()) {
            responseRouteDtoList.add(RouteConverter.toDTO(route));
        }
        return new ResponseEntity<>(responseRouteDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RouteDto> getRoute(@PathVariable Integer id) {
        try {
            Route searchedRoute = routeService.getById(id);
            return new ResponseEntity<>(RouteConverter.toDTO(searchedRoute), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RouteDto> postRoute(@RequestBody RouteDto routeDto) {
        Route createdRoute = Route.builder()
                .from(routeDto.getFrom())
                .to(routeDto.getTo())
                .build();
        Route responseRoute = routeService.create(createdRoute);
        return new ResponseEntity<>(RouteConverter.toDTO(responseRoute), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RouteDto> putRoute(@RequestBody RouteDto routeDto, @PathVariable Integer id) {
        try {
            Route updatedRouteValues = Route.builder()
                    .from(routeDto.getFrom())
                    .to(routeDto.getTo())
                    .build();
            routeService.updateById(updatedRouteValues, id);
            routeDto.setId(id);
            return new ResponseEntity<>(routeDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RouteDto> deleteRoute(@PathVariable Integer id) {
        try {
            routeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
