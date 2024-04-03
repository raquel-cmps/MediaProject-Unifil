package org.example.project_media.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Series extends Media{

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull(message = "Episode required")
    private int episode;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Series() {
    }

    public Series(String name, Date launchDate, int classify, Long id, int episode, Director director) {
        super(name, launchDate, classify);
        Id = id;
        this.episode = episode;
        this.director = director;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
