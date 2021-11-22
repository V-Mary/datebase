package com.martciv.service;

import com.martciv.DAO.implementation.DeliveryDAOmpl;
import com.martciv.model.DeliveryEntity;

import java.sql.SQLException;
import java.util.List;

public class DeliveryService {
    public List<DeliveryEntity> findAll() throws SQLException {
        return new DeliveryDAOmpl().findAll();
    }

    public DeliveryEntity findById(Integer id) throws SQLException {
        return new DeliveryDAOmpl().findById(id);
    }

    public void create(DeliveryEntity entity) throws SQLException {
        new DeliveryDAOmpl().create(entity);
    }
    public DeliveryEntity update(DeliveryEntity entity) throws SQLException {
        return new DeliveryDAOmpl().update(entity);
    }

    public DeliveryEntity delete(Integer id) throws SQLException {
        return new DeliveryDAOmpl().delete(id);
    }
}
