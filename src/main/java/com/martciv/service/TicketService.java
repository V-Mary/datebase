package com.martciv.service;

import com.martciv.DAO.implementation.TicketDAOmpl;
import com.martciv.model.TicketEntity;

import java.sql.SQLException;
import java.util.List;

public class TicketService {
    public List<TicketEntity> findAll() throws SQLException {
        return new TicketDAOmpl().findAll();
    }

    public TicketEntity findById(Integer id) throws SQLException {
        return new TicketDAOmpl().findById(id);
    }

    public void create(TicketEntity entity) throws SQLException {
        new TicketDAOmpl().create(entity);
    }
    public TicketEntity update(TicketEntity entity) throws SQLException {
        return new TicketDAOmpl().update(entity);
    }

    public TicketEntity delete(Integer id) throws SQLException {
        return new TicketDAOmpl().delete(id);
    }
}
