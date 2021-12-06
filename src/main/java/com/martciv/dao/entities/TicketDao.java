package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.TicketEntity;

public class TicketDao extends GeneralDao<TicketEntity, Integer> {
    public TicketDao() {
        super(TicketEntity.class);
    }
}
