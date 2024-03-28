package org.example.designmovieticketbookingtool.dtos;

import lombok.Data;
import org.example.designmovieticketbookingtool.models.Ticket;

@Data
public class BookTicketResponseDTO {
    private Response response;
    private Ticket ticket;
}
