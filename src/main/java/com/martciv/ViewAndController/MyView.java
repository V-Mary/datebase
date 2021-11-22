package com.martciv.ViewAndController;

import com.martciv.model.*;
import com.martciv.service.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private String selectedTable;
    Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("1", "    1 - Table:Artist");
        menu.put("2", "    2 - Table:Delivery");
        menu.put("3", "    3 - Table:City");
        menu.put("4", "    4 - Table:Street");
        menu.put("5", "    5 - Table:Event");
        menu.put("6", "    6 - Table:Ticket");
        menu.put("7", "    7 - Table:User");
        menu.put("8", "    8 - Table:Insurance");
        menu.put("9", "    9 - Table:Route");
        menu.put("FF", "    FF - Select by id");
        menu.put("CC", "    CC - Create");
        menu.put("UU", "    UU - Update");
        menu.put("DD", "    DD - Delete");

        menu.put("Q", "   Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::selectArtist);
        methodsMenu.put("2", this::selectDelivery);
        methodsMenu.put("3", this::selectCity);
        methodsMenu.put("4", this::selectStreet);
        methodsMenu.put("5", this::selectEvent);
        methodsMenu.put("6", this::selectTicket);
        methodsMenu.put("7", this::selectUser);
        methodsMenu.put("8", this::selectInsurance);
        methodsMenu.put("9", this::selectRoute);
        methodsMenu.put("FF", this::findById);
        methodsMenu.put("CC", this::create);
        methodsMenu.put("UU", this::update);
        methodsMenu.put("DD", this::delete);
    }

    private void selectArtist() throws SQLException {
        selectedTable = "artist";
        System.out.println("Artist:");
        List<ArtistEntity> entities = new ArtistService().findAll();
        for(ArtistEntity entity: entities)
            System.out.println(entity);
    }
    private void selectDelivery() throws SQLException {
        selectedTable = "delivery";
        System.out.println("Delivery:");
        List<DeliveryEntity> entities = new DeliveryService().findAll();
        for(DeliveryEntity entity: entities)
            System.out.println(entity);
    }
    private void selectCity() throws SQLException {
        selectedTable = "city";
        System.out.println("City:");
        List<CityEntity> entities = new CityService().findAll();
        for(CityEntity entity: entities)
            System.out.println(entity);
    }
    private void selectStreet() throws SQLException {
        selectedTable = "street";
        System.out.println("Street:");
        List<StreetEntity> entities = new StreetService().findAll();
        for(StreetEntity entity: entities)
            System.out.println(entity);
    }
    private void selectEvent() throws SQLException {
        selectedTable = "event";
        System.out.println("Event:");
        List<EventEntity> entities = new EventService().findAll();
        for(EventEntity entity: entities)
            System.out.println(entity);
    }
    private void selectTicket() throws SQLException {
        selectedTable = "ticket";
        System.out.println("Ticket:");
        List<TicketEntity> entities = new TicketService().findAll();
        for(TicketEntity entity: entities)
            System.out.println(entity);
    }
    private void selectUser() throws SQLException {
        selectedTable = "user";
        System.out.println("User:");
        List<UserEntity> entities = new UserService().findAll();
        for(UserEntity entity: entities)
            System.out.println(entity);
    }
    private void selectInsurance() throws SQLException {
        selectedTable = "insurance";
        System.out.println("Insurance:");
        List<InsuranceEntity> entities = new InsuranceService().findAll();
        for(InsuranceEntity entity: entities)
            System.out.println(entity);
    }
    private void selectRoute() throws SQLException {
        selectedTable = "route";
        System.out.println("Route:");
        List<RouteEntity> entities = new RouteService().findAll();
        for(RouteEntity entity: entities)
            System.out.println(entity);
    }

    private void findById() throws SQLException {
        switch (selectedTable) {
            case "artist":
                int id = Integer.parseInt(input.nextLine());
                System.out.println(new ArtistService().findById(id));
                break;
            case "delivery":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new DeliveryService().findById(id));
                break;
            case "city":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new CityService().findById(id));
                break;
            case "street":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new StreetService().findById(id));
                break;
            case "event":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new EventService().findById(id));
                break;
            case "route":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new RouteService().findById(id));
                break;
            case "insurance":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new InsuranceService().findById(id));
                break;
            case "ticket":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new TicketService().findById(id));
                break;
            case "user":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new UserService().findById(id));
                break;

        }     System.out.println("Write id");

    }

    private void create() throws SQLException {
        switch (selectedTable) {
            case "artist":
                System.out.println("id");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                String name = input.nextLine();

                new ArtistService().create(new ArtistEntity(id, name));
                break;
            case "delivery":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("city_id");
                int city_id = Integer.parseInt(input.nextLine());
                System.out.println("street_id");
                int street_id = Integer.parseInt(input.nextLine());
                new DeliveryService().create(new DeliveryEntity(id, city_id, street_id));
                break;
            case "city":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("city");
                String city = input.nextLine();
                new CityService().create(new CityEntity(id, city));
                break;
            case "street":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("street");
                String street = input.nextLine();
                System.out.println("number");
                int number = Integer.parseInt(input.nextLine());
                new StreetService().create(new StreetEntity(id, street, number));
                break;
            case "insurance":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                int price = Integer.parseInt(input.nextLine());
                System.out.println("price");
                int days = Integer.parseInt(input.nextLine());
                System.out.println("days");
                new InsuranceService().create(new InsuranceEntity(id, name, price, days));
                break;
            case "route":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("from");
                String from = input.nextLine();
                System.out.println("ro");
                String to = input.nextLine();
                new RouteService().create(new RouteEntity(id, from, to));
                break;
            case "ticket":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("place");
                int place = Integer.parseInt(input.nextLine());
                System.out.println("price");
                int ticket_price = Integer.parseInt(input.nextLine());
                System.out.println("user_id");
                int user_id = Integer.parseInt(input.nextLine());
                System.out.println("delivery_id");
                int delivery_id = Integer.parseInt(input.nextLine());
                System.out.println("event_id");
                int event_id = Integer.parseInt(input.nextLine());
                System.out.println("insurance_id");
                int insurance_id = Integer.parseInt(input.nextLine());
                new TicketService().create(new TicketEntity(id, name, place, ticket_price,
                        user_id, delivery_id, event_id, insurance_id));
                break;
            case "user":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("age");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("ordered_tickets");
                int ordered_tickets = Integer.parseInt(input.nextLine());
                new UserService().create(new UserEntity(id, name, age, ordered_tickets));
                break;
            case "event":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("type");
                String type = input.nextLine();
                System.out.println("all_places");
                int all_places = Integer.parseInt(input.nextLine());
                System.out.println("free_places");
                int free_places = Integer.parseInt(input.nextLine());
                System.out.println("city_id");
                city_id = Integer.parseInt(input.nextLine());
                System.out.println("street_id");
                street_id = Integer.parseInt(input.nextLine());
                System.out.println("artist_id");
                int artist_id = Integer.parseInt(input.nextLine());
                System.out.println("route_id");
                int route_id = Integer.parseInt(input.nextLine());
                new EventService().create(new EventEntity(id, type, all_places, free_places,
                        city_id, street_id, artist_id, route_id));
                break;
        }
    }

    private void delete() throws SQLException {
        System.out.println("id to delete");
        int id = Integer.parseInt(input.nextLine());
        switch (selectedTable) {
            case "artist":
                System.out.println(new ArtistService().delete(id));
                break;
            case "delivery":
                System.out.println(new DeliveryService().delete(id));
                break;
            case "city":
                System.out.println(new CityService().delete(id));
                break;
            case "street":
                System.out.println(new StreetService().delete(id));
                break;
            case "event":
                System.out.println(new EventService().delete(id));
                break;
            case "route":
                System.out.println(new RouteService().delete(id));
                break;
            case "insurance":
                System.out.println(new InsuranceService().delete(id));
                break;
            case "ticket":
                System.out.println(new TicketService().delete(id));
                break;
            case "user":
                System.out.println(new UserService().delete(id));
                break;
        }
    }

    private void update() throws SQLException, ParseException {
        switch (selectedTable) {
            case "artist":
                System.out.println("id to update");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                String name = input.nextLine();
                System.out.println(new ArtistService().update(new ArtistEntity(id, name)));
                break;
            case "delivery":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("city_id");
                int city_id = Integer.parseInt(input.nextLine());
                System.out.println("street_id");
                int street_id = Integer.parseInt(input.nextLine());
                System.out.println(new DeliveryService().update(new DeliveryEntity(id, city_id, street_id)));
                break;
            case "city":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("city");
                String city = input.nextLine();
                System.out.println(new CityService().update(new CityEntity(id, city)));
                break;
            case "street":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("street");
                String street = input.nextLine();
                System.out.println("number");
                int number = Integer.parseInt(input.nextLine());
                System.out.println( new StreetService().update(new StreetEntity(id, street, number)));
                break;
            case "event":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("type");
                String type = input.nextLine();
                System.out.println("all_places");
                int all_places = Integer.parseInt(input.nextLine());
                System.out.println("free_places");
                int free_places = Integer.parseInt(input.nextLine());
                System.out.println("city_id");
                city_id = Integer.parseInt(input.nextLine());
                System.out.println("street_id");
                street_id = Integer.parseInt(input.nextLine());
                System.out.println("artist_id");
                int artist_id = Integer.parseInt(input.nextLine());
                System.out.println("route_id");
                int route_id = Integer.parseInt(input.nextLine());

                System.out.println(new EventService().update(new EventEntity(id, type, all_places, free_places,
                        city_id, street_id, artist_id, route_id)));
                break;
            case "route":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("from");
                String from = input.nextLine();
                System.out.println("ro");
                String to = input.nextLine();
                System.out.println(new RouteService().update(new RouteEntity(id, from, to)));
                break;
            case "insurance":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                int price = Integer.parseInt(input.nextLine());
                System.out.println("price");
                int days = Integer.parseInt(input.nextLine());
                System.out.println("days");
                System.out.println(new InsuranceService().update(new InsuranceEntity(id, name, price, days)));
                break;
            case "ticket":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("place");
                int place = Integer.parseInt(input.nextLine());
                System.out.println("price");
                int ticket_price = Integer.parseInt(input.nextLine());
                System.out.println("user_id");
                int user_id = Integer.parseInt(input.nextLine());
                System.out.println("delivery_id");
                int delivery_id = Integer.parseInt(input.nextLine());
                System.out.println("event_id");
                int event_id = Integer.parseInt(input.nextLine());
                System.out.println("insurance_id");
                int insurance_id = Integer.parseInt(input.nextLine());
                System.out.println(new TicketService().update(new TicketEntity(id, name, place, ticket_price,
                        user_id, delivery_id, event_id, insurance_id)));
                break;
            case "user":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("age");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("ordered_tickets");
                int ordered_tickets = Integer.parseInt(input.nextLine());
                System.out.println(new UserService().update(new UserEntity(id, name, age, ordered_tickets)));
                break;

        }
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key: menu.keySet())
            if(key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu() {
        System.out.println("\nSubMenu:");
        for (String key: menu.keySet())
            if (key.length() != 1) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please select menu point");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.equals("Q")) {break;}

            if (keyMenu.matches("^\\d")) {
                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException | ParseException e) {
                    e.printStackTrace();
                }
                outputSubMenu();
                System.out.println("Please, select menu point");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
}
