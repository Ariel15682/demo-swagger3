package com.example.swagger3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import lombok.Data;

//@Data
@Entity
public class Plant {
//    private final Long id;
//    private final String name;
//    private final String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String name;

    @NotBlank
    @Size(min = 0, max = 30)
    private String description;

    public Plant() { }

    public Plant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}