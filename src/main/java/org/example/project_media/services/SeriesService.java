package org.example.project_media.services;

import org.example.project_media.Models.Series;
import org.example.project_media.repositories.SeriesRepository;
import org.example.project_media.services.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService implements CrudInterface<Series> {

    @Autowired
    private SeriesRepository _repository;
    
    @Override
    public List<Series> findAll() {
        return _repository.findAll();
    }

    @Override
    public Optional<Series> findById(long id) {
        if(!_repository.existsById(id)){
            throw new RuntimeException();
        }
        return _repository.findById(id);
    }

    @Override
    public void createEntity(Series entity) {
        try{
            _repository.save(entity);
        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void editEntity(long id, Series entity) {
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
