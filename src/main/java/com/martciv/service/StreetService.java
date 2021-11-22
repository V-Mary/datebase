package com.martciv.service;

import com.martciv.DAO.implementation.StreetDAOmpl;
import com.martciv.model.StreetEntity;

import java.sql.SQLException;
import java.util.List;

public class StreetService {
    public List<StreetEntity> findAll() throws SQLException {
        return new StreetDAOmpl().findAll();
    }

    public StreetEntity findById(Integer id) throws SQLException {
        return new StreetDAOmpl().findById(id);
    }

    public void create(StreetEntity entity) throws SQLException {
        new StreetDAOmpl().create(entity);
    }
    public StreetEntity update(StreetEntity entity) throws SQLException {
        return new StreetDAOmpl().update(entity);
    }

    public StreetEntity delete(Integer id) throws SQLException {
        return new StreetDAOmpl().delete(id);
    }
}
