package com.example.experiment_2_2_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.experiment_2_2_2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Optimized query: avoids N+1 problem
    @Query("SELECT p FROM Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();

    // Native SQL query
    @Query(value = "SELECT * FROM product ORDER BY price DESC", nativeQuery = true)
    List<Product> findProductsByNativeQuery();
}