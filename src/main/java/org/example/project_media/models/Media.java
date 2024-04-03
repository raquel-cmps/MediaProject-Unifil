package org.example.project_media.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@MappedSuperclass
public abstract class Media {

    @NotNull(message = "Name required")
    private String name;
    @NotNull(message = "Date required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date launchDate;
    @NotNull(message = "Classify required")
    @Min(value = 1, message = "classify must be at least 1")
    @Max(value = 5, message = "classify must be at most 5")
    private int classify;

    public Media(String name, Date launchDate, int classify) {
        this.name = name;
        this.launchDate = launchDate;
        this.classify = classify;
    }

    public Media() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
