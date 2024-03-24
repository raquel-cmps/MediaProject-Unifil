package org.example.project_media.services;

import org.example.project_media.Models.Movie;
import org.example.project_media.repositories.MovieRepository;
import org.example.project_media.services.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements CrudInterface<Movie> {

    @Autowired
    private MovieRepository _repository;
    
    @Override
    public List<Movie> findAll() {
        return _repository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        if(!_repository.existsById(id)){
            throw new RuntimeException();
        }
        return _repository.findById(id);
    }

    @Override
    public void createEntity(Movie entity) {
        try{
            _repository.save(entity);
        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void editEntity(long id, Movie entity) {
        try{
            if(!_repository.existsById(id)){
                throw new RuntimeException("Id not found");
            }
            entity.setId(id);
            _repository.save(entity);

        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void deleteEntity(long id) {
        try{
            if(!_repository.existsById(id)){
                throw new RuntimeException("Id not found");
            }
            _repository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
