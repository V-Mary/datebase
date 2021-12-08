package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.TicketConverter;
import com.martciv.models.domain.Ticket;
import com.martciv.models.dto.TicketDto;
import com.martciv.service.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDto>> getTicketList() {
        List<TicketDto> responseTicketDtoList = new ArrayList<>();
        for (Ticket ticket: ticketService.getAll()) {
            responseTicketDtoList.add(TicketConverter.toDTO(ticket));
        }
        return new ResponseEntity<>(responseTicketDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable Integer id) {
        try {
            Ticket searchedTicket = ticketService.getById(id);
            return new ResponseEntity<>(TicketConverter.toDTO(searchedTicket), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TicketDto> postTicket(@RequestBody TicketDto ticketDto) {
        Ticket createdTicket = Ticket.builder()
                .name(ticketDto.getName())
                .place(ticketDto.getPlace())
                .price(ticketDto.getPrice())

                .build();
        Ticket responseTicket = ticketService.create(createdTicket);
        return new ResponseEntity<>(TicketConverter.toDTO(responseTicket), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TicketDto> putTicket(@RequestBody TicketDto ticketDto, @PathVariable Integer id) {
        try {
            Ticket updatedTicketValues = Ticket.builder()
                    .name(ticketDto.getName())
                    .place(ticketDto.getPlace())
                    .price(ticketDto.getPrice())

                    .build();
            ticketService.updateById(updatedTicketValues, id);
            ticketDto.setId(id);
            return new ResponseEntity<>(ticketDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TicketDto> deleteTicket(@PathVariable Integer id) {
        try {
            ticketService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}