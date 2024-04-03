package org.example.project_media.repositories;

import org.example.project_media.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    @Query("select avg(m.classify) from Movie m where m.director.id = :id")
    Double averageMovie(@Param("id") long id);

    @Query("select avg(s.classify) from Series s where s.director.id = :id")
    Double averageSeries(@Param("id") long id);

    //@Query(value = "", nativeQuery = true)
}
