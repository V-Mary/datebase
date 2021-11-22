package com.martciv.service;

import com.martciv.DAO.implementation.UserDAOmpl;
import com.martciv.model.UserEntity;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public List<UserEntity> findAll() throws SQLException {
        return new UserDAOmpl().findAll();
    }

    public UserEntity findById(Integer id) throws SQLException {
        return new UserDAOmpl().findById(id);
    }

    public void create(UserEntity entity) throws SQLException {
        new UserDAOmpl().create(entity);
    }
    public UserEntity update(UserEntity entity) throws SQLException {
        return new UserDAOmpl().update(entity);
    }

    public UserEntity delete(Integer id) throws SQLException {
        return new UserDAOmpl().delete(id);
    }
}
