package com.martciv.controller.entites;
import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.EventDao;
import com.martciv.models.entity.EventEntity;
public class EventController extends GeneralController<EventEntity, Integer> {
    public EventController() {
        super(new EventDao());
    }

    @Override
    public EventEntity createNewEntity() {
        EventEntity newEvent = new EventEntity();
        System.out.println("Enter id:");
        newEvent.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter type:");
        newEvent.setType(input.nextLine());
        System.out.println("Enter number of all places:");
        newEvent.setAllPlaces(Integer.parseInt(input.nextLine()));
        System.out.println("Enter number of free places:");
        newEvent.setFreePlaces(Integer.parseInt(input.nextLine()));
        System.out.println("Enter route_id:");
        newEvent.setRouteId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter artist_id:");
        newEvent.setArtistId(Integer.parseInt(input.nextLine()));

        return newEvent;
    }

    @Override
    public EventEntity createUpdEntity(String stringId) {
        EventEntity newEvent = new EventEntity();
        System.out.println("Enter new type:");
        newEvent.setType(input.nextLine());
        System.out.println("Enter new number of all places:");
        newEvent.setAllPlaces(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new number of free places:");
        newEvent.setFreePlaces(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new route_id:");
        newEvent.setRouteId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new artist_id:");
        newEvent.setArtistId(Integer.parseInt(input.nextLine()));

        return newEvent;
    }
}
