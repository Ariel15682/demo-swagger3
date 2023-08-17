package com.example.swagger3.services;

import com.example.swagger3.controllers.PlantController;
import com.example.swagger3.entities.Plant;
import com.example.swagger3.repositories.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
//import java.util.ArrayList;

@Service
public class PlantService {

    //Atributos
//    List<Plant> plants = new ArrayList<>(){
//        {
//            add(new Plant(1L, "plant1", "this is plant1"));
//            add(new Plant(2L, "plant2", "this is plant2"));
//            add(new Plant(3L, "plant3", "this is plant3"));
//        }
//    };

    private final PlantRepository repository;

    private final Logger log = LoggerFactory.getLogger(PlantController.class);

    //Constructores
    public PlantService(PlantRepository repository) {
        this.repository = repository;
    }


    //CRUD sobre la entidad Plant
    // Metodo que devuelve la lista con las plantas
    public List<Plant> findAll() {
        //return plants; //Sin persistencia; devolvia una lista de plantas
        return repository.findAll();
    }


    // Metodo que busca una planta de la BD x su id
    public ResponseEntity<Plant> findById(long id) {
        Optional<Plant> optional = repository.findById(id);
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Plant> update(Plant plant) {
        // Si no se pasa un id
        if(plant.getId() == null){
            // Se hace uso de un Log para registrar cualquier error que surge
            log.warn("Trying to update a non existent plant");
            return ResponseEntity.badRequest().build();
        }
        // Si no existe id quiere decir que es una creacion y no un update/modificacion
        if(!repository.existsById(plant.getId())){
            log.warn("Trying to update a non existent plant");
            return ResponseEntity.notFound().build();
        }
        repository.save(plant);
        return ResponseEntity.ok(plant);
    }

}