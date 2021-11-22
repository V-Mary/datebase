package com.martciv.service;

import com.martciv.DAO.implementation.InsuranceDAOmpl;
import com.martciv.model.InsuranceEntity;

import java.sql.SQLException;
import java.util.List;

public class InsuranceService {
    public List<InsuranceEntity> findAll() throws SQLException {
        return new InsuranceDAOmpl().findAll();
    }

    public InsuranceEntity findById(Integer id) throws SQLException {
        return new InsuranceDAOmpl().findById(id);
    }

    public void create(InsuranceEntity entity) throws SQLException {
        new InsuranceDAOmpl().create(entity);
    }
    public InsuranceEntity update(InsuranceEntity entity) throws SQLException {
        return new InsuranceDAOmpl().update(entity);
    }

    public InsuranceEntity delete(Integer id) throws SQLException {
        return new InsuranceDAOmpl().delete(id);
    }
}
