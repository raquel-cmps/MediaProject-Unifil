package org.example.project_media.controllers;

import jakarta.validation.Valid;
import org.example.project_media.Models.Movie;
import org.example.project_media.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService _service;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        var entity = _service.findAll();
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable long id){
        try{
            var byId = _service.findById(id);
            return ResponseEntity.ok(byId);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> postMovie(@Valid @RequestBody Movie entity){
        try{
            _service.createEntity(entity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> putMovie(@PathVariable long id, @RequestBody Movie entity){
        try{
            _service.editEntity(id, entity);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id){
        try{
            _service.deleteEntity(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}
