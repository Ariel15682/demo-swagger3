package com.example.swagger3;

import com.example.swagger3.entities.Plant;
import com.example.swagger3.repositories.PlantRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = org.springframework.boot.SpringApplication.run(SpringApplication.class, args);

        PlantRepository repository = context.getBean(PlantRepository.class);

        Plant plant1 = new Plant("plant1", "this is plant1");
        Plant plant2 = new Plant("plant2", "this is plant2");
        Plant plant3 = new Plant("plant3", "this is plant3");

        repository.save(plant1);
        repository.save(plant2);
        repository.save(plant3);

    }

}