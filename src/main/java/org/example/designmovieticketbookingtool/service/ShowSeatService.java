package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.models.Show;
import org.example.designmovieticketbookingtool.models.ShowSeat;

import java.util.List;

public interface ShowSeatService {
    List<ShowSeat> getShowSeats(List<Integer> ShowSeatIds);
    List<ShowSeat> checkShowSeatsAvailableForGivenShow(Show show, List<Integer> showSeatIDs);
}
