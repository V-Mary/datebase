package com.martciv.view;

import com.martciv.controller.GeneralController;
import com.martciv.controller.entites.*;
import com.martciv.models.entity.*;
import com.martciv.view.exceptions.*;


import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class ViewOptions {
    private Class<?> currentEntity;
    private GeneralController<?, ?> currentController;
    private final HashMap<String, Class<?>> availableEntities;
    private final HashMap<String, GeneralController<?, ?>> tableControllers;

    public ViewOptions() {
        availableEntities = new HashMap<>();
        setAvailableEntities();
        tableControllers = new HashMap<>();
        setTableControllers();
    }

    public void printHelp(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            System.out.println(new StringBuilder()
                    .append("+-----------------------------------------------+\n")
                    .append(" help, h - display help menu\n")
                    .append(" show-tables - show all available tables\n")
                    .append(" current-table - display current table\n")
                    .append(" describe - display fields of current table\n")
                    .append(" choose-table <table-name> - change table\n")
                    .append(" get-all - display contents of the table\n")
                    .append(" get <id> - get element from the table by it's id value\n")
                    .append(" create - create element with passed field values\n")
                    .append(" update <id> - updates element with <id> with passed field values\n")
                    .append(" delete <id> - deletes element by it's id value\n")
                    .append(" quit, q - quit\n")
                    .append("+-----------------------------------------------+\n")
            );
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getAllContent(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            if (!isTableChosen()) {
                throw  new TableNotChosenException();
            }
            List<?> entities = currentController.getAll();
            if (entities.size() == 0) {
                System.out.printf("Table %s is empty\n", currentEntity.getSimpleName());
            }
            else {
                entities.forEach((entity) -> System.out.println(entity.toString()));
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.printf("Cannot get data from table '%s'\n", currentEntity.getSimpleName());
        }
    }

    public void getById(List<String> params) {
        try {
            validateParamsNum(params.size(), 1);
            if (!isTableChosen()) {
                throw new TableNotChosenException();
            }
            System.out.println(currentController.getById(params.get(0)));
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.printf("Cannot convert passed value to Id: %s\n", params.get(0));
        }
        catch (NullPointerException e) {
            System.out.printf("Cannot found element with id = %s\n", params.get(0));
        }
    }

    public void create(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            if (!isTableChosen()) {
                throw new TableNotChosenException("Please, choose table before creating a new object");
            }
            if (currentController.create()) {
                System.out.println("Successfully created new object");
            }
            else {
                System.out.println("Object creation failed");
            }
        }
        catch (ViewException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(List<String> params) {
        try {
            validateParamsNum(params.size(), 1);
            if (!isTableChosen()) {
                throw new TableNotChosenException("Please, choose table before updating an object\n");
            }
            if (currentController.update(params.get(0))){
                System.out.printf("Successfully updated object with id=%s\n", params.get(0));
            } else {
                System.out.println("Object update failed\n");
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.printf("Cannot convert passed value to Id: %s\n", params.get(0));
        }
    }

    public void delete(List<String> params) {
        try {
            validateParamsNum(params.size(), 1);
            if (!isTableChosen()) {
                throw new TableNotChosenException();
            }
            if (currentController.delete(params.get(0))) {
                System.out.printf("Successfully deleted object with id %s\n", params.get(0));
            } else {
                System.out.printf("Cannot delete object with id %s\n", params.get(0));
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.printf("Cannot convert passed value to Id: %s\n", params.get(0));
        }
    }

    public void printAvailableTables(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            StringBuilder allTables = new StringBuilder();
            allTables.append("All tables: ");
            availableEntities.keySet().forEach(
                    tableName -> allTables.append(String.format("%s, ", tableName))
            );
            allTables.delete(allTables.length() - 2, allTables.length() - 1);
            System.out.println(allTables);
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }

    }

    public void chooseTable(List<String> params) {
        try {
            validateParamsNum(params.size(), 1);
            if (availableEntities.containsKey(params.get(0))) {
                currentEntity = availableEntities.get(params.get(0));
                currentController = tableControllers.get(params.get(0));
                System.out.printf("Table %s selected\n", params.get(0));
            } else {
                throw new WrongTableNameException(params.get(0));
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }

    }

    public void describeTable(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            if (isTableChosen()) {
                System.out.printf("Current table: %s\n", currentEntity.getSimpleName());
                for (Field field: currentEntity.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Column.class)) {
                        System.out.printf("\t%s - %s\n", field.getName(), field.getType().getSimpleName());
                    }
                }
            } else {
                throw new TableNotChosenException();
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printCurrentTable(List<String> params) {
        try {
            validateParamsNum(params.size(), 0);
            if (isTableChosen()) {
                System.out.printf("Current table: %s\n", currentEntity.getSimpleName());
            } else  {
                throw new TableNotChosenException();
            }
        } catch (ViewException e) {
            System.out.println(e.getMessage());
        }
    }

    public void declareExit(View view) {
        view.setCanExit(true);
    }

    private boolean isTableChosen() {
        return (currentEntity != null);
    }

    private void validateParamsNum(Integer passedParamsNum,Integer expectedParamsNum) throws WrongParamNumException {
        if (!passedParamsNum.equals(expectedParamsNum)) {
            throw new WrongParamNumException(passedParamsNum, expectedParamsNum);
        }
    }

    private void setAvailableEntities() {
        availableEntities.put("artist", ArtistEntity.class);
        availableEntities.put("delivery", DeliveryEntity.class);
        availableEntities.put("event", EventEntity.class);
        availableEntities.put("insurance", InsuranceEntity.class);
        availableEntities.put("route", RouteEntity.class);
        availableEntities.put("ticket", TicketEntity.class);
        availableEntities.put("user", UserEntity.class);
    }

    private void setTableControllers() {
        tableControllers.put("artist", new ArtistController());
        tableControllers.put("delivery", new DeliveryController());
        tableControllers.put("event", new EventController());
        tableControllers.put("insurance", new InsuranceController());
        tableControllers.put("route", new RouteController());
        tableControllers.put("ticket", new TicketController());
        tableControllers.put("user", new UserController());
    }
}