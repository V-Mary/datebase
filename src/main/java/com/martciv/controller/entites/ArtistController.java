package com.martciv.controller.entites;

import com.martciv.controller.GeneralController;
import com.martciv.dao.entities.ArtistDao;
import com.martciv.models.entity.ArtistEntity;

public class ArtistController extends GeneralController<ArtistEntity, Integer>{
    public ArtistController() {
        super(new ArtistDao());
    }

    @Override
    public ArtistEntity createNewEntity() {
        ArtistEntity newArtist = new ArtistEntity();
        System.out.println("Enter id:");
        newArtist.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Enter name:");
        newArtist.setName(input.nextLine());
        return newArtist;
    }

    @Override
    public ArtistEntity createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        ArtistEntity updatedArtist =  createNewEntity();
        if (updatedArtist != null) {
            updatedArtist.setId(id);
            return updatedArtist;
        }
        return null;
    }

}
