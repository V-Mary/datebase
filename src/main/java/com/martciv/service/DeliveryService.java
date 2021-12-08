package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.DeliveryRepository;
import com.martciv.models.domain.Delivery;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    public Delivery getById(Integer id) {
        return deliveryRepository.findById(id).get();
    }

    @Transactional
    public Delivery create(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Transactional
    public void updateById(Delivery delivery, Integer id) {
        Delivery updatedDelivery = deliveryRepository.findById(id).get();
        updatedDelivery.setCity(delivery.getCity());
        updatedDelivery.setStreet(delivery.getStreet());
        updatedDelivery.setNumber(delivery.getNumber());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!deliveryRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        deliveryRepository.deleteById(id);
    }
}
