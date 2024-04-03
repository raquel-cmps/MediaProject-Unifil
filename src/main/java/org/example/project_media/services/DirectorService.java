package org.example.project_media.services;

import org.example.project_media.models.Director;
import org.example.project_media.repositories.DirectorRepository;
import org.example.project_media.services.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService implements CrudInterface<Director> {

    @Autowired
    private DirectorRepository _repository;

    @Override
    public List<Director> findAll() {
        return _repository.findAll();
    }

    @Override
    public Optional<Director> findById(long id) {
        if(!_repository.existsById(id)){
            throw new RuntimeException();
        }
        return _repository.findById(id);
    }

    @Override
    public void createEntity(Director entity) {
        try{
            _repository.save(entity);
        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void editEntity(long id, Director entity) {
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

    public Double averageMovie(long id){
        try{
            if(!_repository.existsById(id))
                throw new RuntimeException("Id not found");
            return _repository.averageMovie(id);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Double averageSeries(long id){
        try{
            if(!_repository.existsById(id))
                throw new RuntimeException("Id not found");
            return _repository.averageSeries(id);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
