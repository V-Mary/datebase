package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.DeliveryEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DeliveryDAOmpl implements GeneralDAO <DeliveryEntity, Integer> {

    private static final String FIND_ALL = "SELECT * FROM martciv_maria.delivery";
    private static final String CREATE = "INSERT martciv_maria.delivery" +
            "( `city_id`, `street_id`) VALUES ( ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.delivery WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.delivery SET `city_id`= ?, `street_id`= ? WHERE (`id` = ?)";
    private static final String DELETE = "DELETE FROM martciv_maria.delivery WHERE (`id` = ?)";


    @Override
    public List<DeliveryEntity> findAll() throws SQLException {
        List<DeliveryEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    DeliveryEntity delivery = new DeliveryEntity(
                            rs.getInt("id"),
                            rs.getInt("city_id"),
                            rs.getInt("street_id")
                    );
                    entities.add(delivery);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public DeliveryEntity findById(Integer id) throws SQLException {
        DeliveryEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new DeliveryEntity(
                            rs.getInt("id"),
                            rs.getInt("city_id"),
                            rs.getInt("street_id")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(DeliveryEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, entity.getCity_id());
            statement.setInt(2, entity.getStreet_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public DeliveryEntity update(DeliveryEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setInt(2, entity.getCity_id());
            statement.setInt(3, entity.getStreet_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public DeliveryEntity delete(Integer id) throws SQLException {
        DeliveryEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
