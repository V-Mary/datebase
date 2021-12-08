package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.InsuranceConverter;
import com.martciv.models.domain.Insurance;
import com.martciv.models.dto.InsuranceDto;
import com.martciv.service.InsuranceService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/insurance")
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<InsuranceDto>> getInsuranceList() {
        List<InsuranceDto> responseInsuranceDtoList = new ArrayList<>();
        for (Insurance insurance: insuranceService.getAll()) {
            responseInsuranceDtoList.add(InsuranceConverter.toDTO(insurance));
        }
        return new ResponseEntity<>(responseInsuranceDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InsuranceDto> getInsurance(@PathVariable Integer id) {
        try {
            Insurance searchedInsurance = insuranceService.getById(id);
            return new ResponseEntity<>(InsuranceConverter.toDTO(searchedInsurance), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> postInsurance(@RequestBody InsuranceDto insuranceDto) {
        Insurance createdInsurance = Insurance.builder()
                .name(insuranceDto.getName())
                .build();
        Insurance responseInsurance = insuranceService.create(createdInsurance);
        return new ResponseEntity<>(InsuranceConverter.toDTO(responseInsurance), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InsuranceDto> putInsurance(@RequestBody InsuranceDto insuranceDto, @PathVariable Integer id) {
        try {
            Insurance updatedInsuranceValues = Insurance.builder()
                    .name(insuranceDto.getName())
                    .price(insuranceDto.getPrice())
                    .days(insuranceDto.getDays())
                    .build();
            insuranceService.updateById(updatedInsuranceValues, id);
            insuranceDto.setId(id);
            return new ResponseEntity<>(insuranceDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<InsuranceDto> deleteInsurance(@PathVariable Integer id) {
        try {
            insuranceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
