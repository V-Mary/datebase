package com.martciv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}