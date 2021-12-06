package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.RouteEntity;

public class RouteDao extends GeneralDao<RouteEntity, Integer>{
    public RouteDao() {
        super(RouteEntity.class);
    }
}
