package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.UserEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAOmpl implements GeneralDAO <UserEntity, Integer> {

    private static final String FIND_ALL = "SELECT * FROM martciv_maria.user";
    private static final String CREATE = "INSERT martciv_maria.user" +
            "(`name`, `age`, `ordered_tickets`) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.user WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.user SET `name`=?, `age`= ?, " +
            "`ordered_tickets`=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM martciv_maria.user WHERE (`id` = ?)";

    @Override
    public List<UserEntity> findAll() throws SQLException {
        List<UserEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    UserEntity user = new UserEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getInt("ordered_tickets")
                    );
                    entities.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public UserEntity findById(Integer id) throws SQLException {
        UserEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new UserEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getInt("ordered_tickets")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(UserEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getAge());
            statement.setInt(3, entity.getOrdered_tickets());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public UserEntity update(UserEntity entity) throws SQLException {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getAge());
            statement.setInt(4, entity.getOrdered_tickets());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public UserEntity delete(Integer id) throws SQLException {
        UserEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
