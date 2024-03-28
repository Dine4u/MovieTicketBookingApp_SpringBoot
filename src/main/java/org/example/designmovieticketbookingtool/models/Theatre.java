package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data       //Generates Getters and Setters
@Entity(name="theatres")
public class Theatre extends BaseModel{
    private String name;
    private String address;

    @OneToMany(mappedBy = "theatre")    //for foreignKey instead of Mapping Table
    private List<Screen> screens;

    @ManyToOne
    private City city;      //for foreignKey instead of Mapping Table
}
