package com.martciv.dao;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.martciv.models.util.HibernateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class GeneralDao<Entity, Id extends Serializable> implements AbstractDao<Entity, Id> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Getter
    private final Class<Entity> entityClass;

    public GeneralDao(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<Entity> getAll() {
        List<Entity> resultList = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            resultList = session.createQuery("from " + entityClass.getSimpleName()).getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("An error occurred during getting data from table:");
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public Entity getById(Id id) {
        Entity resultEntity = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            resultEntity = session.get(entityClass, id);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("An error occurred during getting a row:");
            e.printStackTrace();
        }

        return resultEntity;
    }

    @Override
    public boolean create(Entity newItem) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newItem);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("An error occurred during creating a row:");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Entity updItem) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(updItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred during updating a row: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Id id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Entity entityToDelete = session.get(entityClass, id);
            if (entityToDelete != null) {
                session.delete(entityToDelete);
            }
            else {
                transaction.commit();
                return false;
            }
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println("An error occurred during deleting a table: " + e.getMessage());
            return false;
        }
    }
}
