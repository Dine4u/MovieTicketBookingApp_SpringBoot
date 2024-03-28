package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data       //Generates Getters and Setters
@Entity(name="screens")
public class Screen extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "screen")     //for foreignKey instead of Mapping Table
    private List<Seat> seats;

    @ManyToOne      //for foreignKey instead of Mapping Table
    private Theatre theatre;
}
