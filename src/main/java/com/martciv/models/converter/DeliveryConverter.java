package com.martciv.models.converter;
import com.martciv.models.domain.Delivery;
import com.martciv.models.dto.DeliveryDto;
public class DeliveryConverter {
    public static DeliveryDto toDTO(Delivery delivery) {
        DeliveryDto convertedDto = DeliveryDto.builder()
                .id(delivery.getId())
                .city(delivery.getCity())
                .street(delivery.getStreet())
                .number(delivery.getNumber())
                .build();
        return convertedDto;
    }
}
