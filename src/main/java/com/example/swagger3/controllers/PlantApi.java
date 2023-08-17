package com.example.swagger3.controllers;

//import java.util.Collection;
import java.util.List;
import com.example.swagger3.entities.Plant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.http.HttpStatus;

@Tag(name = "Plant", description = "The Plant Api")
public interface PlantApi {


    @Operation(
            summary = "Fetch all plants",
            description = "Fetches all plant entities and their data from data source")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation") })
    ResponseEntity<List<Plant>> getAll();


    @Operation(summary = "Get a plant by its id")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Found the plant",
        content = { @Content(mediaType = "application/json") }),
    @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
    @ApiResponse(responseCode = "404", description = "Plant not found", content = @Content) })
    //@ResponseStatus(HttpStatus.OK)
    ResponseEntity<Plant> findPlantById(@Parameter(description = "id of plant to be searched") @PathVariable long id);


    @Operation(
            summary = "Update/modify plants",
            description = "Modify an existent plant entities by id")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation"),
    @ApiResponse(responseCode = "404", description = "Plant not found", content = @Content) })
    //@ResponseStatus(HttpStatus.OK)
    ResponseEntity<Plant> updatePlant(@RequestBody Plant plant);

    //Create

    //Delete
}
