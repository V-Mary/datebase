package com.martciv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Route;

@Repository
public interface  RouteRepository extends JpaRepository<Route, Integer>{
}
