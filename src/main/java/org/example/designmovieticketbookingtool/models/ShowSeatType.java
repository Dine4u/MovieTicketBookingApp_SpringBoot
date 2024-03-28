package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data       //Generates Getters and Setters
@Entity(name="showseattypes")
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private double price;
}
