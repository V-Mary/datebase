package com.martciv.models.converter;
import com.martciv.models.domain.Ticket;
import com.martciv.models.dto.TicketDto;
public class TicketConverter {
    public static TicketDto toDTO(Ticket ticket) {
        TicketDto convertedDto = TicketDto.builder()
                .id(ticket.getId())
                .name(ticket.getName())
                .place(ticket.getPlace())
                .price(ticket.getPrice())
                .event_id(ticket.getEvent().getId())
                .insurance_id(ticket.getInsurance().getId())
                .user_id(ticket.getUser().getId())
                .delivery_id(ticket.getDelivery().getId())
                .build();
        return convertedDto;
    }
}
