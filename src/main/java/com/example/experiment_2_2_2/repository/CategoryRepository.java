package com.example.experiment_2_2_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.experiment_2_2_2.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}