package com.martciv.controller.entites;
import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.TicketDao;
import com.martciv.models.entity.TicketEntity;
public class TicketController extends GeneralController<TicketEntity, Integer> {
    public TicketController() {
        super(new TicketDao());
    }

    @Override
    public TicketEntity createNewEntity() {
        TicketEntity newTicket= new TicketEntity();
        System.out.println("Enter id:");
        newTicket.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter name:");
        newTicket.setName(input.nextLine());
        System.out.println("Enter place:");
        newTicket.setPlace(Integer.parseInt(input.nextLine()));
        System.out.println("Enter price:");
        newTicket.setPrice(Integer.parseInt(input.nextLine()));
        System.out.println("Enter event id:");
        newTicket.setEventId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter insurance id:");
        newTicket.setInsuranceId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter user id:");
        newTicket.setUserId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter delivery id:");
        newTicket.setDeliveryId(Integer.parseInt(input.nextLine()));
        return newTicket;
    }

    @Override
    public TicketEntity createUpdEntity(String stringId) {
        TicketEntity newTicket= new TicketEntity();
        System.out.println("Enter new name:");
        newTicket.setName(input.nextLine());
        System.out.println("Enter new place:");
        newTicket.setPlace(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new price:");
        newTicket.setPrice(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new event id:");
        newTicket.setEventId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new insurance id:");
        newTicket.setInsuranceId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new user id:");
        newTicket.setUserId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new delivery id:");
        newTicket.setDeliveryId(Integer.parseInt(input.nextLine()));
        return newTicket;
    }
}
