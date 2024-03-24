package org.example.project_media.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie extends Media{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    public Movie() {
    }

    public Movie(String name, Date launchDate, int classify, Long id, Director director) {
        super(name, launchDate, classify);
        Id = id;
        this.director = director;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
