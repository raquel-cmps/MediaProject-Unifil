package org.example.project_media.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudInterface<T>{
    List<T> findAll();
    Optional<T> findById(long id);
    void createEntity(T entity);
    void editEntity(long id ,T entity);
    void deleteEntity(long id);
}
