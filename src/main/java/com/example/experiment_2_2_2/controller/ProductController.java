package com.example.experiment_2_2_2.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.experiment_2_2_2.entity.Product;
import com.example.experiment_2_2_2.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return productService.getProducts(pageable);
    }

    // Optimized endpoint using JOIN FETCH
    @GetMapping("/optimized")
    public List<Product> getProductsWithCategory() {
        return productService.getProductsWithCategory();
    }

    // Native SQL endpoint
    @GetMapping("/native")
    public List<Product> getProductsUsingNativeQuery() {
        return productService.getProductsUsingNativeQuery();
    }
}