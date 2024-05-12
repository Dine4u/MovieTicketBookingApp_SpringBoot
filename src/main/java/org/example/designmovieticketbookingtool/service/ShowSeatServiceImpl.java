package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.models.SeatStatus;
import org.example.designmovieticketbookingtool.models.Show;
import org.example.designmovieticketbookingtool.models.ShowSeat;
import org.example.designmovieticketbookingtool.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService{
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Override
    public List<ShowSeat> getShowSeats(List<Integer> showSeatIds) {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(Collections.singleton(showSeatIds));
        return showSeats;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)//instead of taking transaction at whole generate ticket method, taken only available check method. can we do it? - Yes we can do this
    @Override
    public List<ShowSeat> checkShowSeatsAvailableForGivenShow(Show show, List<Integer> showSeatIDs) {

        //Working application using @Query annotation and passing our own native SQL query,
//        List<ShowSeat> allAvailableSeatsForGivenShow = showSeatRepository.getAllAvailableSeatsForGivenShow(showSeatIDs, show);

        //Not Working application due to incorrect order in below method
//        List<ShowSeat> allAvailableSeatsForGivenShow = showSeatRepository.findShowSeatsByIdIsInAndShowAndSeatStatus(show,showSeatIDs, SeatStatus.AVAILABLE);   //can we pass parameter in different order and method name can be different? --> No we cannot, not working

        ////Working application with declared query
        List<ShowSeat> allAvailableSeatsForGivenShow = showSeatRepository.findShowSeatsByIdIsInAndShowAndSeatStatus(showSeatIDs,show, SeatStatus.AVAILABLE);

        return allAvailableSeatsForGivenShow;
    }
}
