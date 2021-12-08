package com.martciv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Event;

@Repository
public interface  EventRepository extends JpaRepository<Event, Integer>{
}
