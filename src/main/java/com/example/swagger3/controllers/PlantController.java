package com.example.swagger3.controllers;

import java.util.List;
import com.example.swagger3.entities.Plant;
import com.example.swagger3.services.PlantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
//import org.webjars.NotFoundException;


/*
* Se implementan las formas de obtener respuestas HTTP y manejar los casos en los que no se encuentra el
* objeto buscado o si se envia algun parametro incorrecto. Este proyecto se adapto incorporando Swagger y persistencia.
* El controlador gestiona las peticiones a traves de su entry-point, solicita la informacion a la clase de servicio
* que a su vez la solicita al repositorio para por ultimo devolver el resultado.
 */


@Tag(name = "Plant", description = "the Plant Api")
@RestController
@RequestMapping("/plant")
public class PlantController implements PlantApi{

    //Atributos
    private final PlantService service;


    //Constructores
    public PlantController(PlantService service) {
        this.service = service;
    }


    //Metodos
    @Operation(
            summary = "Fetch all plants",
            description = "fetches all plant entities and their data from data source")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation") })
    @Override
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Plant>> getAll() {
        var plants = service.findAll();
        return ResponseEntity.ok(plants);
    }


    @Operation(summary = "Get a plant by its id")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Found the plant",
            content = { @Content(mediaType = "application/json") }),
    @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
    @ApiResponse(responseCode = "404", description = "Plant not found", content = @Content) })
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Plant> findPlantById(@Parameter(description = "id of plant to be searched") @PathVariable long id) {
        return service.findById(id);
    }


    @Operation(
            summary = "Update/modify plants",
            description = "Modify an existent plant entities by Id")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation"),
    @ApiResponse(responseCode = "404", description = "Plant not found", content = @Content) })
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
        // El proceso de actualizacion
        ResponseEntity<Plant> result = service.update(plant);
        return result;
    }


    //Create

    //Delete
}