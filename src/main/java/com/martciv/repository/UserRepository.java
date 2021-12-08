package com.martciv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.martciv.models.domain.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
}
