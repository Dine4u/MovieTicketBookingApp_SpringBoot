package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.*;
import lombok.Data;

@Data       //Generates Getters and Setters
@Entity(name="showseats")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated(value = EnumType.STRING)
    private SeatStatus seatStatus;
    @ManyToOne
    private User bookerUser;
    @ManyToOne
    private Ticket ticket;          //for foreignKey instead of Mapping Table
}
