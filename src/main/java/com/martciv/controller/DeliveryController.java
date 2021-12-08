package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.DeliveryConverter;
import com.martciv.models.domain.Delivery;
import com.martciv.models.dto.DeliveryDto;
import com.martciv.service.DeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getDeliveryList() {
        List<DeliveryDto> responseDeliveryDtoList = new ArrayList<>();
        for (Delivery delivery: deliveryService.getAll()) {
            responseDeliveryDtoList.add(DeliveryConverter.toDTO(delivery));
        }
        return new ResponseEntity<>(responseDeliveryDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable Integer id) {
        try {
            Delivery searchedDelivery = deliveryService.getById(id);
            return new ResponseEntity<>(DeliveryConverter.toDTO(searchedDelivery), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DeliveryDto> postDelivery(@RequestBody DeliveryDto deliveryDto) {
        Delivery createdDelivery = Delivery.builder()
                .city(deliveryDto.getCity())
                .street(deliveryDto.getStreet())
                .number(deliveryDto.getNumber())
                .build();
        Delivery responseDelivery = deliveryService.create(createdDelivery);
        return new ResponseEntity<>(DeliveryConverter.toDTO(responseDelivery), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DeliveryDto> putDelivery(@RequestBody DeliveryDto deliveryDto, @PathVariable Integer id) {
        try {
            Delivery updatedDeliveryValues = Delivery.builder()
                    .city(deliveryDto.getCity())
                    .street(deliveryDto.getStreet())
                    .number(deliveryDto.getNumber())
                    .build();
            deliveryService.updateById(updatedDeliveryValues, id);
            deliveryDto.setId(id);
            return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeliveryDto> deleteDelivery(@PathVariable Integer id) {
        try {
            deliveryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
