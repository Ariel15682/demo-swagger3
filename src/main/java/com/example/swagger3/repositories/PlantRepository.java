package com.example.swagger3.repositories;

import com.example.swagger3.entities.Plant;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {

}