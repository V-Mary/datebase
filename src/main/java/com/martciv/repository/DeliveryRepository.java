package com.martciv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
}
