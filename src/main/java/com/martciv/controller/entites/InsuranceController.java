package com.martciv.controller.entites;
import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.InsuranceDao;
import com.martciv.models.entity.InsuranceEntity;
public class InsuranceController extends GeneralController<InsuranceEntity, Integer> {
    public InsuranceController() {
        super(new InsuranceDao());
    }

    @Override
    public InsuranceEntity createNewEntity() {
        InsuranceEntity newInsurance = new InsuranceEntity();
        System.out.println("Enter id:");
        newInsurance.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter name:");
        newInsurance.setName(input.nextLine());
        System.out.println("Enter price:");
        newInsurance.setPrice(Integer.parseInt(input.nextLine()));
        System.out.println("Enter days:");
        newInsurance.setDays(Integer.parseInt(input.nextLine()));
        return newInsurance;
    }

    @Override
    public InsuranceEntity createUpdEntity(String stringId) {
        InsuranceEntity newInsurance = new InsuranceEntity();
        System.out.println("Enter new name:");
        newInsurance.setName(input.nextLine());
        System.out.println("Enter new price:");
        newInsurance.setPrice(Integer.parseInt(input.nextLine()));
        System.out.println("Enter new days:");
        newInsurance.setDays(Integer.parseInt(input.nextLine()));
        return newInsurance;
    }
}
