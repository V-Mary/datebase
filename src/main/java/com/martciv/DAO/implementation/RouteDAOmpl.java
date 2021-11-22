package com.martciv.DAO.implementation;

import com.martciv.DAO.GeneralDAO;
import com.martciv.model.RouteEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOmpl implements GeneralDAO <RouteEntity, Integer> {

    private static final String FIND_ALL = "SELECT * FROM martciv_maria.route";
    private static final String CREATE = "INSERT martciv_maria.route" +
            "(`from`, `to`) VALUES (?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.route WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.route SET `from`= ?, `to` = ? WHERE (`id` = ?)";
    private static final String DELETE = "DELETE FROM martciv_maria.route WHERE (`id` = ?);";


    @Override
    public List<RouteEntity> findAll() throws SQLException {
        List<RouteEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    RouteEntity route = new RouteEntity(
                            rs.getInt("id"),
                            rs.getString("from"),
                            rs.getString("to")
                    );
                    entities.add(route);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public RouteEntity findById(Integer id) throws SQLException {
        RouteEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new RouteEntity(
                            rs.getInt("id"),
                            rs.getString("from"),
                            rs.getString("to")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(RouteEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getFrom());
            statement.setString(2, entity.getTo());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public RouteEntity update(RouteEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getFrom());
            statement.setString(2, entity.getTo());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public RouteEntity delete(Integer id) throws SQLException {
        RouteEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
