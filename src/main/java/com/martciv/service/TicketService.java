package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.TicketRepository;
import com.martciv.models.domain.Ticket;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Integer id) {
        return ticketRepository.findById(id).get();
    }

    @Transactional
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Transactional
    public void updateById(Ticket ticket, Integer id) {
        Ticket updatedTicket = ticketRepository.findById(id).get();
        updatedTicket.setName(ticket.getName());
        updatedTicket.setPlace(ticket.getPlace());
        updatedTicket.setPrice(ticket.getPrice());
        updatedTicket.setEvent(ticket.getEvent());
        updatedTicket.setInsurance(ticket.getInsurance());
        updatedTicket.setUser(ticket.getUser());
        updatedTicket.setDelivery(ticket.getDelivery());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!ticketRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        ticketRepository.deleteById(id);
    }
}