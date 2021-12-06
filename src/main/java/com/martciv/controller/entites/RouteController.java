package com.martciv.controller.entites;
import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.RouteDao;
import com.martciv.models.entity.RouteEntity;
public class RouteController extends GeneralController<RouteEntity, Integer> {
    public RouteController() {
        super(new RouteDao());
    }

    @Override
    public RouteEntity createNewEntity() {
        RouteEntity newRoute = new RouteEntity();
        System.out.println("Enter id:");
        newRoute.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter from:");
        newRoute.setFrom(input.nextLine());
        System.out.println("Enter to:");
        newRoute.setTo(input.nextLine());
        return newRoute;
    }

    @Override
    public RouteEntity createUpdEntity(String stringId) {
        RouteEntity newRoute = new RouteEntity();
        System.out.println("Enter new from:");
        newRoute.setFrom(input.nextLine());
        System.out.println("Enter new to:");
        newRoute.setTo(input.nextLine());
        return newRoute;
    }
}
