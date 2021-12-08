package com.martciv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Ticket;

@Repository
public interface  TicketRepository extends JpaRepository<Ticket, Integer>{
}
