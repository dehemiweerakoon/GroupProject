package com.example.GroupProject.Repository;

import com.example.GroupProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByemail(String email);
    Boolean existsByEmail(String email);
}
