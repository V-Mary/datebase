package com.martciv.DAO.implementation;

import com.martciv.DAO.GeneralDAO;
import com.martciv.model.ArtistEntity;
import com.martciv.model.RouteEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOmpl implements GeneralDAO <ArtistEntity, Integer> {
    private static final String FIND_ALL = "SELECT * FROM martciv_maria.artist";
    private static final String CREATE = "INSERT martciv_maria.artist" +
            "(`name`) VALUES (?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.artist WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.artist SET name= ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM martciv_maria.artist WHERE (`id` = ?)";

    @Override
    public List<ArtistEntity> findAll() throws SQLException {
        List<ArtistEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    ArtistEntity artist = new ArtistEntity(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                    entities.add(artist);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public ArtistEntity findById(Integer id) throws SQLException {
        ArtistEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new ArtistEntity(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(ArtistEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public ArtistEntity update(ArtistEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public ArtistEntity delete(Integer id) throws SQLException {
        ArtistEntity entity = findById(id);
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
