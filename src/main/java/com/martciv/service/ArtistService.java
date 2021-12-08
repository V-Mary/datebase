package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.ArtistRepository;
import com.martciv.models.domain.Artist;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Integer id) {
        return artistRepository.findById(id).get();
    }

    @Transactional
    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    @Transactional
    public void updateById(Artist artist, Integer id) {
        Artist updatedArtist = artistRepository.findById(id).get();
        updatedArtist.setName(artist.getName());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!artistRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        artistRepository.deleteById(id);
    }
}
