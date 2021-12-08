package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.EventRepository;
import com.martciv.models.domain.Event;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(Integer id) {
        return eventRepository.findById(id).get();
    }

    @Transactional
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Transactional
    public void updateById(Event event, Integer id) {
        Event updatedEvent = eventRepository.findById(id).get();
        updatedEvent.setType(event.getType());
        updatedEvent.setAll_places(event.getAll_places());
        updatedEvent.setFree_places(event.getFree_places());
        updatedEvent.setRoute(event.getRoute());
        updatedEvent.setType(event.getType());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!eventRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        eventRepository.deleteById(id);
    }
}
