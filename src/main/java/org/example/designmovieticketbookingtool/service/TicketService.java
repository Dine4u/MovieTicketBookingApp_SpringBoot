package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.models.ShowSeat;
import org.example.designmovieticketbookingtool.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket generateTicket(int userid, int showid, List<Integer> showSeats);
}
