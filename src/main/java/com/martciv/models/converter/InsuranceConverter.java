package com.martciv.models.converter;
import com.martciv.models.domain.Insurance;
import com.martciv.models.dto.InsuranceDto;
public class InsuranceConverter {
    public static InsuranceDto toDTO(Insurance insurance) {
        InsuranceDto convertedDto = InsuranceDto.builder()
                .id(insurance.getId())
                .name(insurance.getName())
                .price(insurance.getPrice())
                .days(insurance.getDays())
                .build();
        return convertedDto;
    }
}
