package com.martciv.controller;

import lombok.Getter;
import com.martciv.dao.GeneralDao;
import com.martciv.models.manager.Manager;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public abstract class GeneralController<Entity, Id extends Serializable> implements AbstractController<Entity> {
    private final GeneralDao<Entity, Id> dao;
    @Getter
    private final Manager<Entity, Integer> manager;
    protected final Scanner input = new Scanner(System.in);


    public GeneralController(GeneralDao<Entity, Id> dao) {
        this.dao = dao;
        this.manager = new Manager<>(dao.getEntityClass());
    }

    @Override
    public List<Entity> getAll() {
        return dao.getAll();
    }

    @Override
    public Entity getById(String idString) {
        return dao.getById((Id) manager.stringIdToPk(idString));
    }

    @Override
    public boolean create() {
        try {
            Entity createdItem = createNewEntity();
            return dao.create(createdItem);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("An error occurred during entity creation");
            return false;
        }
    }

    @Override
    public boolean update(String stringId) {
        try {
            Entity updItem = createUpdEntity(stringId);
            return dao.update(updItem);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("An error occurred during setting field(s) value");
            return false;
        }
    }

    @Override
    public boolean delete(String idString) {
        return dao.delete((Id) manager.stringIdToPk(idString));
    }

    @Override
    public Entity createNewEntity()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return manager.createEntity();
    }

    @Override
    public Entity createUpdEntity(String stringId)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return manager.updateEntity();
    }
}