package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.UserEntity;

public class UserDao extends GeneralDao<UserEntity, Integer>{
    public UserDao() {
        super(UserEntity.class);
    }
}
