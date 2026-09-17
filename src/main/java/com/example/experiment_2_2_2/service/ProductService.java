package com.example.experiment_2_2_2.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.experiment_2_2_2.entity.Product;
import com.example.experiment_2_2_2.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable("products")
    public Page<Product> getProducts(Pageable pageable) {

        System.out.println("Fetching products from database...");

        return productRepository.findAll(pageable);
    }

    // Optimized query using JOIN FETCH
    public List<Product> getProductsWithCategory() {

        System.out.println("Fetching products using JOIN FETCH...");

        return productRepository.findAllWithCategory();
    }

    // Native SQL query
    public List<Product> getProductsUsingNativeQuery() {

        System.out.println("Fetching products using Native SQL...");

        return productRepository.findProductsByNativeQuery();
    }
}