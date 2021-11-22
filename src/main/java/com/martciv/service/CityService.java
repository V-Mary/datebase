package com.martciv.service;

import com.martciv.DAO.implementation.CityDaoImpl;
import com.martciv.model.CityEntity;

import java.sql.SQLException;
import java.util.List;

public class CityService {

    public List<CityEntity> findAll() throws SQLException {
        return new CityDaoImpl().findAll();
    }

    public CityEntity findById(Integer id) throws SQLException {
        return new CityDaoImpl().findById(id);
    }

    public void create(CityEntity entity) throws SQLException {
        new CityDaoImpl().create(entity);
    }

    public CityEntity update(CityEntity entity) throws SQLException {
        return new CityDaoImpl().update(entity);
    }

    public CityEntity delete(Integer id) throws SQLException {
        return new CityDaoImpl().delete(id);
    }

}
