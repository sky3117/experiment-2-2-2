package com.example.experiment_2_2_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.experiment_2_2_2.entity.Category;
import com.example.experiment_2_2_2.entity.Product;
import com.example.experiment_2_2_2.repository.CategoryRepository;
import com.example.experiment_2_2_2.repository.ProductRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {

        return args -> {

            Category electronics = new Category("Electronics");
            Category accessories = new Category("Accessories");
            Category audio = new Category("Audio");

            categoryRepository.save(electronics);
            categoryRepository.save(accessories);
            categoryRepository.save(audio);

            productRepository.save(
                    new Product("Laptop", 55000, electronics));

            productRepository.save(
                    new Product("Mobile", 25000, electronics));

            productRepository.save(
                    new Product("Monitor", 12000, electronics));

            productRepository.save(
                    new Product("Keyboard", 1500, accessories));

            productRepository.save(
                    new Product("Mouse", 800, accessories));

            productRepository.save(
                    new Product("Headphones", 2500, audio));
        };
    }
}