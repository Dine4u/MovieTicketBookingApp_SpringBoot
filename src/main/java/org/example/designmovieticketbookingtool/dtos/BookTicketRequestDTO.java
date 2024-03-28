package org.example.designmovieticketbookingtool.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDTO {
    private int userId;
    private int showId;
    private List<Integer> showSeatIds;
}
