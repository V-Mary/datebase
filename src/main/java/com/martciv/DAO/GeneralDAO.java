package com.martciv.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T, ID> {
    List<T> findAll() throws SQLException;

    T findById(Integer id) throws SQLException;

    void create(T entity) throws SQLException;

    T update(T entity) throws SQLException;

    T delete(ID id) throws SQLException;

}
