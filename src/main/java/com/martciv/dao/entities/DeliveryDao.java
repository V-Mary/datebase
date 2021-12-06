package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.DeliveryEntity;

public class DeliveryDao extends GeneralDao<DeliveryEntity, Integer> {
    public DeliveryDao() {
        super(DeliveryEntity.class);
    }
}