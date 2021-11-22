package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.DeliveryEntity;
import com.martciv.model.TicketEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TicketDAOmpl implements GeneralDAO <TicketEntity, Integer >{
    private static final String FIND_ALL = "SELECT * FROM martciv_maria.ticket";
    private static final String CREATE = "INSERT martciv_maria.ticket" +
            "(`name`, `place`, `price`, `user_id`, `delivery_id`" +
            ", `event_id`, `insurance_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.ticket WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.ticket SET `name`=?, `place`= ?, `price`= ?" +
            ", `user_id`= ?, `delivery_id`= ?, `insurance_id`= ?, `event_id`= ? WHERE (`id` = ?)";
    private static final String DELETE = "DELETE FROM martciv_maria.ticket WHERE (`id` = ?)";

    @Override
    public List<TicketEntity> findAll() throws SQLException {
        List<TicketEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    TicketEntity ticket = new TicketEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("place"),
                            rs.getInt("price"),
                            rs.getInt("user_id"),
                            rs.getInt("delivery_id"),
                            rs.getInt("event_id"),
                            rs.getInt("insurance_id")
                    );
                    entities.add(ticket);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public TicketEntity findById(Integer id) throws SQLException {
        TicketEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new TicketEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("place"),
                            rs.getInt("price"),
                            rs.getInt("user_id"),
                            rs.getInt("delivery_id"),
                            rs.getInt("event_id"),
                            rs.getInt("insurance_id")
                    );

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(TicketEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getPlace());
            statement.setInt(3, entity.getPrice());
            statement.setInt(4, entity.getUser_id());
            statement.setInt(5, entity.getDelivery_id());
            statement.setInt(6, entity.getEvent_id());
            statement.setInt(7, entity.getInsurance_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public TicketEntity update(TicketEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getPlace());
            statement.setInt(3, entity.getPrice());
            statement.setInt(4, entity.getUser_id());
            statement.setInt(5, entity.getDelivery_id());
            statement.setInt(6, entity.getEvent_id());
            statement.setInt(7, entity.getInsurance_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public TicketEntity delete(Integer id) throws SQLException {
        TicketEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
