package com.martciv.controller.entites;
import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.UserDao;
import com.martciv.models.entity.UserEntity;
public class UserController extends GeneralController<UserEntity, Integer> {
    public UserController() {
        super(new UserDao());
    }

    @Override
    public UserEntity createNewEntity() {
        UserEntity newUser = new UserEntity();
        System.out.println("Enter id:");
        newUser.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter name:");
        newUser.setName(input.nextLine());
        System.out.println("Enter age:");
        newUser.setAge(Integer.parseInt(input.nextLine()));
        System.out.println("Enter number of ordering:");
        newUser.setOrderedTickets(Integer.parseInt(input.nextLine()));
        return newUser;
    }

    @Override
    public UserEntity createUpdEntity(String stringId) {
        UserEntity newUser = new UserEntity();
        System.out.println("Enter new name:");
        newUser.setName(input.nextLine());
        System.out.println("Enter new age:");
        newUser.setAge(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new number of ordering:");
        newUser.setOrderedTickets(Integer.parseInt(input.nextLine()));
        return newUser;
    }
}
