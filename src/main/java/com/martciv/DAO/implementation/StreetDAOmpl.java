package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.StreetEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StreetDAOmpl implements GeneralDAO <StreetEntity, Integer> {

    private static final String FIND_ALL = "SELECT * FROM martciv_maria.street";
    private static final String CREATE = "INSERT martciv_maria.street" +
            "(`street`, `number`) VALUES (?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.street WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.street SET street=?, number = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM martciv_maria.street WHERE (`id` = ?)";

    @Override
    public List<StreetEntity> findAll() throws SQLException {
        List<StreetEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    StreetEntity street = new StreetEntity(
                            rs.getInt("id"),
                            rs.getString("street"),
                            rs.getInt("number")
                    );
                    entities.add(street);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public StreetEntity findById(Integer id) throws SQLException {
        StreetEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new StreetEntity(
                            rs.getInt("id"),
                            rs.getString("street"),
                            rs.getInt("number")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(StreetEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getStreet());
            statement.setInt(2, entity.getNumber());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public StreetEntity update(StreetEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getStreet());
            statement.setInt(3, entity.getNumber());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public StreetEntity delete(Integer id) throws SQLException {
        StreetEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
