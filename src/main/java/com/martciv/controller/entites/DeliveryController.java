package com.martciv.controller.entites;


import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.DeliveryDao;
import com.martciv.models.entity.ArtistEntity;
import com.martciv.models.entity.DeliveryEntity;

public class DeliveryController extends GeneralController<DeliveryEntity, Integer>{
    public DeliveryController() {
        super(new DeliveryDao());
    }

    @Override
    public DeliveryEntity createNewEntity() {
        DeliveryEntity newDelivery = new DeliveryEntity();
        System.out.println("Enter id:");
        newDelivery.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter city:");
        newDelivery.setCity(input.nextLine());
        System.out.println("Enter street:");
        newDelivery.setStreet(input.nextLine());

        return newDelivery;
    }

    @Override
    public DeliveryEntity createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        DeliveryEntity updatedDelivery =  createNewEntity();
        if (updatedDelivery != null) {
            updatedDelivery.setId(id);
            return updatedDelivery;
        }
        return null;
    }

}
