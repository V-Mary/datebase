package com.martciv.service;

import com.martciv.DAO.implementation.ArtistDAOmpl;
import com.martciv.model.ArtistEntity;

import java.sql.SQLException;
import java.util.List;

public class ArtistService{
    public List<ArtistEntity> findAll() throws SQLException {
        return new ArtistDAOmpl().findAll();
    }

    public ArtistEntity findById(Integer id) throws SQLException {
        return new ArtistDAOmpl().findById(id);
    }

    public void create(ArtistEntity entity) throws SQLException {
        new ArtistDAOmpl().create(entity);
    }

    public ArtistEntity update(ArtistEntity entity) throws SQLException {
        return new ArtistDAOmpl().update(entity);
    }

    public ArtistEntity delete(Integer id) throws SQLException {
        return new ArtistDAOmpl().delete(id);
    }
}
