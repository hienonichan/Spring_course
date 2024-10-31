package com.example.SellerWeb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SellerWeb.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findByEmail(String email);

    User findById(long id);

    void deleteById(long id);

    boolean existsByEmail(String email);
}
