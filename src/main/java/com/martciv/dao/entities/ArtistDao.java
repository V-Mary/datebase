package com.martciv.dao.entities;

import com.martciv.dao.GeneralDao;
import com.martciv.models.entity.ArtistEntity;

public class ArtistDao extends GeneralDao<ArtistEntity, Integer>{
    public ArtistDao() {
        super(ArtistEntity.class);
    }
}
