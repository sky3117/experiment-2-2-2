package com.example.experiment_2_2_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Experiment222Application {

    public static void main(String[] args) {
        SpringApplication.run(Experiment222Application.class, args);
    }
}