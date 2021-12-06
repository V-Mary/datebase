package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.EventEntity;

public class EventDao extends GeneralDao<EventEntity, Integer> {
    public EventDao() {
        super(EventEntity.class);
    }
}
