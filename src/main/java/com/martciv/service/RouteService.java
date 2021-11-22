package com.martciv.service;

import com.martciv.DAO.implementation.RouteDAOmpl;
import com.martciv.model.RouteEntity;

import java.sql.SQLException;
import java.util.List;

public class RouteService {
    public List<RouteEntity> findAll() throws SQLException {
        return new RouteDAOmpl().findAll();
    }

    public RouteEntity findById(Integer id) throws SQLException {
        return new RouteDAOmpl().findById(id);
    }

    public void create(RouteEntity entity) throws SQLException {
        new RouteDAOmpl().create(entity);
    }
    public RouteEntity update(RouteEntity entity) throws SQLException {
        return new RouteDAOmpl().update(entity);
    }

    public RouteEntity delete(Integer id) throws SQLException {
        return new RouteDAOmpl().delete(id);
    }
}
