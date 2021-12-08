package com.martciv.models.converter;
import com.martciv.models.domain.User;
import com.martciv.models.dto.UserDto;
public class UserConverter {
    public static UserDto toDTO(User user) {
        UserDto convertedDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .ordered_tickets(user.getOrdered_tickets())
                .build();
        return convertedDto;
    }
}
