package com.martciv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
