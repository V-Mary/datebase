package com.martciv.service;

import com.martciv.DAO.implementation.EventDAOmpl;
import com.martciv.model.EventEntity;

import java.sql.SQLException;
import java.util.List;

public class EventService {
    public List<EventEntity> findAll() throws SQLException {
        return new EventDAOmpl().findAll();
    }

    public EventEntity findById(Integer id) throws SQLException {
        return new EventDAOmpl().findById(id);
    }

    public void create(EventEntity entity) throws SQLException {
        new EventDAOmpl().create(entity);
    }
    public EventEntity update(EventEntity entity) throws SQLException {
        return new  EventDAOmpl().update(entity);
    }

    public EventEntity delete(Integer id) throws SQLException {
        return new  EventDAOmpl().delete(id);
    }
}
