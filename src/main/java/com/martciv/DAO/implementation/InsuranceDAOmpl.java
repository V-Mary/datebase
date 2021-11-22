package com.martciv.DAO.implementation;
import com.martciv.DAO.GeneralDAO;
import com.martciv.model.InsuranceEntity;
import com.martciv.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class InsuranceDAOmpl implements GeneralDAO <InsuranceEntity, Integer> {
    private static final String FIND_ALL = "SELECT * FROM martciv_maria.insurance";
    private static final String CREATE = "INSERT martciv_maria.insurance" +
            "(`name`, `price`, `days`) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM martciv_maria.insurance WHERE id=?";
    private static final String UPDATE = "UPDATE martciv_maria.insurance SET `name`=?, `price`= ?, " +
            "`days`=? WHERE (`id` = ?)";
    private static final String DELETE = "DELETE FROM martciv_maria.insurance WHERE (`id` = ?)";

    @Override
    public List<InsuranceEntity> findAll() throws SQLException {
        List<InsuranceEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    InsuranceEntity insurance = new InsuranceEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("days")
                    );
                    entities.add(insurance);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public InsuranceEntity findById(Integer id) throws SQLException {
        InsuranceEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new InsuranceEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("days")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(InsuranceEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getPrice());
            statement.setInt(3, entity.getDays());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public InsuranceEntity update(InsuranceEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getPrice());
            statement.setInt(3, entity.getDays());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return entity;
    }

    @Override
    public InsuranceEntity delete(Integer id) throws SQLException {
        InsuranceEntity entity = findById(id);

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}
