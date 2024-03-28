package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data       //Generates Getters and Setters
@Entity(name="shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
}
