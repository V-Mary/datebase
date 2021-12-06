package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.InsuranceEntity;

public class InsuranceDao extends GeneralDao<InsuranceEntity, Integer>{
    public InsuranceDao() {
        super(InsuranceEntity.class);
    }
}
