package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data       //Generates Getters and Setters
@Entity(name="users")
public class User extends BaseModel{
    private String name;
    private String phone;
}
