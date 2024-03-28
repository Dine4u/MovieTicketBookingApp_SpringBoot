package org.example.designmovieticketbookingtool.service;

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

    @Transactional(isolation = Isolation.SERIALIZABLE)//instead of taking transaction at whole generate ticket method, taken only available check method. can we do it?
    @Override
    public List<ShowSeat> checkShowSeatsAvailableForGivenShow(int showid, List<Integer> showSeatIDs) {
        List<ShowSeat> availableShowSeats = showSeatRepository.findShowSeatsByIdIsInAndShowIdAndSeatStatus_Available(showSeatIDs,showid);   //can we pass parameter in different order and method name can be different?

        //Above lines are correct but hardcoding available seats as below to make application work - Application worked
        List<ShowSeat> availableShowSeatsHardCoded=List.of(new ShowSeat());
        return availableShowSeats;
    }
}
