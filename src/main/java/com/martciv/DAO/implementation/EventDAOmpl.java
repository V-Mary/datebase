package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.ArtistEntity;
import com.martciv.model.EventEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EventDAOmpl implements GeneralDAO <EventEntity, Integer> {

    private static final String FIND_ALL = "SELECT * FROM martciv_maria.event";
    private static final String CREATE = "INSERT martciv_maria.event" +
            "(`type`, `all_places`, `free_places`, `city_id`, `street_id`" +
            ", `artist_id`, `route_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.event WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.event SET `type`=?, `all_places`= ?, " +
            "`free_places`=?,`city_id`=?, `street_id`= ? WHERE (`id` = ?)";
    private static final String DELETE = "DELETE FROM martciv_maria.event WHERE (`id` = ?)";

    @Override
    public List<EventEntity> findAll() throws SQLException {
        List<EventEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    EventEntity event = new EventEntity(
                            rs.getInt("id"),
                            rs.getString("type"),
                            rs.getInt("all_places"),
                            rs.getInt("free_places"),
                            rs.getInt("city_id"),
                            rs.getInt("street_id"),
                            rs.getInt("artist_id"),
                            rs.getInt("route_id")
                    );
                    entities.add(event);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public EventEntity findById(Integer id) throws SQLException {
        EventEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new EventEntity(
                            rs.getInt("id"),
                            rs.getString("type"),
                            rs.getInt("all_places"),
                            rs.getInt("free_places"),
                            rs.getInt("city_id"),
                            rs.getInt("street_id"),
                            rs.getInt("artist_id"),
                            rs.getInt("route_id")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(EventEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getType());
            statement.setInt(2, entity.getAll_places());
            statement.setInt(3, entity.getFree_places());
            statement.setInt(4, entity.getCity_id());
            statement.setInt(5, entity.getStreet_id());
            statement.setInt(6, entity.getArtist_id());
            statement.setInt(7, entity.getRoute_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public EventEntity update(EventEntity entity) throws SQLException {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, entity.getType());
            statement.setInt(2, entity.getAll_places());
            statement.setInt(3, entity.getFree_places());
            statement.setInt(4, entity.getCity_id());
            statement.setInt(5, entity.getStreet_id());
            statement.setInt(6, entity.getArtist_id());
            statement.setInt(7, entity.getRoute_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public EventEntity delete(Integer id) throws SQLException {
        EventEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
