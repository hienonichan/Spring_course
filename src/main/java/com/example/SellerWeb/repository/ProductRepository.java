package com.example.SellerWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SellerWeb.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);

    Product save(Product product);

    List<Product> findAll();

    void deleteById(long id);
}