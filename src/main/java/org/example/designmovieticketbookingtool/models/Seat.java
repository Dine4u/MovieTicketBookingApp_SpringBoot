package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data       //Generates Getters and Setters
@Entity(name="seats")
public class Seat extends BaseModel{
    private String name;
    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne      //for foreignKey instead of Mapping Table
    private Screen screen;
}
