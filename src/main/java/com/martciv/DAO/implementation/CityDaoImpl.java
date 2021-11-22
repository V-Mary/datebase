package com.martciv.DAO.implementation;

import com.martciv.DAO.GeneralDAO;
import com.martciv.model.ArtistEntity;
import com.martciv.model.CityEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements GeneralDAO<CityEntity, Integer> {
    private static final String FIND_ALL = "SELECT * FROM martciv_maria.city";
    private static final String CREATE = "INSERT martciv_maria.city" +
            "(`city`) VALUES (?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.city WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.city SET city= ? WHERE id=?";
    private static final String DELETE = "DELETE FROM martciv_maria.city WHERE (`id` = ?)";

    @Override
    public List<CityEntity> findAll() throws SQLException {
        List<CityEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    CityEntity city = new CityEntity(
                            rs.getInt("id"),
                            rs.getString("city")
                    );
                    entities.add(city);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public CityEntity findById(Integer id) throws SQLException {
        CityEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new CityEntity(
                            rs.getInt("id"),
                            rs.getString("city")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(CityEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getCity());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public CityEntity update(CityEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getCity());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public CityEntity delete(Integer id) throws SQLException {
        CityEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
