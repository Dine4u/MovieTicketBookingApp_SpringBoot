package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data       //Generates Getters and Setters
@Entity(name = "cities")
public class City extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "city")   //for foreignKey instead of Mapping Table
    private List<Theatre> theatres;
}
