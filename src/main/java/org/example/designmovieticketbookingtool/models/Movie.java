package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data       //Generates Getters and Setters
@Entity(name="movies")
public class Movie extends BaseModel{
    private String name;
    private Genre genre;
}
