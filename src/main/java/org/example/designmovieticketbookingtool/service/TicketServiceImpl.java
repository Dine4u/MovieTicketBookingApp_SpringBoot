package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.exception.EntityNotPresentException;
import org.example.designmovieticketbookingtool.exception.SeatsUnavailableException;
import org.example.designmovieticketbookingtool.models.Show;
import org.example.designmovieticketbookingtool.models.ShowSeat;
import org.example.designmovieticketbookingtool.models.Ticket;
import org.example.designmovieticketbookingtool.models.User;
import org.example.designmovieticketbookingtool.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private UserService userService;
    private ShowService showService;
    private ShowSeatService showSeatService;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(UserService userService, ShowService showService, ShowSeatService showSeatService, TicketRepository ticketRepository) {
        this.userService = userService;
        this.showService = showService;
        this.showSeatService = showSeatService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(int userid, int showid, List<Integer> showSeatIDs) {
        //User,Show,ShowSeats validations
        User user = userService.getUser(userid);
        Show show = showService.getShow(showid);
        List<ShowSeat> showSeats = showSeatService.getShowSeats(showSeatIDs);

        if(showSeats.size()!=showSeatIDs.size()){
            throw new EntityNotPresentException("All or Some given seats are not available in database");
        }

        //Checking availablility of seats for show - below set needs to be transaction with Serilizable and For update
        List<ShowSeat> availableShowSeats = showSeatService.checkShowSeatsAvailableForGivenShow(showid, showSeatIDs);

        if(availableShowSeats.size()!=showSeatIDs.size()){
            throw new SeatsUnavailableException("All or Some given seats are not available for the mentioned show");
        }

        Ticket ticket=new Ticket();
        ticket.setUser(user);
        ticket.setShow(show);
        ticket.setShowSeats(availableShowSeats);
        ticket.setMovie(show.getMovie());

        Date date=new Date();
        ticket.setCreateDate(date);
        ticket.setModifiedDate(date);

        return ticketRepository.save(ticket);       //save the ticket in Database and return ticket with ID
    }
}
