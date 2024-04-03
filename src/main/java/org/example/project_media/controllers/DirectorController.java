package org.example.project_media.controllers;

import jakarta.validation.Valid;
import org.example.project_media.models.Director;
import org.example.project_media.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService _service;

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirector(){
        var entity = _service.findAll();
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Director>> getById(@PathVariable long id){
        try{
            var byId = _service.findById(id);
            return ResponseEntity.ok(byId);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Director> postDirector(@Valid @RequestBody Director entity){
        try{
            _service.createEntity(entity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> putDirector(@PathVariable long id, @RequestBody Director entity){
        try{
            _service.editEntity(id, entity);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Director> deleteDirector(@PathVariable long id){
        try{
            _service.deleteEntity(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/average/movies/{id}")
    public ResponseEntity<Double> avarageMovie(@PathVariable long id){
        try{
            var avg = _service.averageMovie(id);
            return ResponseEntity.ok(avg);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/average/series/{id}")
    public ResponseEntity<Double> avarageSeries(@PathVariable long id){
        try{
            var avg = _service.averageSeries(id);
            return ResponseEntity.ok(avg);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
