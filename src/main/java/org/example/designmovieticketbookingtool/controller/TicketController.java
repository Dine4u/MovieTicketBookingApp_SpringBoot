package org.example.designmovieticketbookingtool.controller;

import org.example.designmovieticketbookingtool.dtos.BookTicketRequestDTO;
import org.example.designmovieticketbookingtool.dtos.BookTicketResponseDTO;
import org.example.designmovieticketbookingtool.dtos.Response;
import org.example.designmovieticketbookingtool.exception.InvalidBookTicketRequestException;
import org.example.designmovieticketbookingtool.models.Ticket;
import org.example.designmovieticketbookingtool.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    @RequestMapping("/bookticket")
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){
        BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();
        try{
            validateInputs(bookTicketRequestDTO);
            Ticket ticket = ticketService.generateTicket(bookTicketRequestDTO.getUserId(), bookTicketRequestDTO.getShowId(), bookTicketRequestDTO.getShowSeatIds());

            bookTicketResponseDTO.setTicket(ticket);
            bookTicketResponseDTO.setResponse(Response.getSuccessResponse());

        } catch (InvalidBookTicketRequestException invalidBookTicketRequestException){
            Response response=Response.getFailureResponse(invalidBookTicketRequestException.getMessage());
            bookTicketResponseDTO.setResponse(response);
        }
        return bookTicketResponseDTO;
    }

    public void validateInputs(BookTicketRequestDTO bookTicketRequestDTO) throws InvalidBookTicketRequestException{
        if(bookTicketRequestDTO.getUserId()<=0){
            throw new InvalidBookTicketRequestException("Invalid User id. User id cannot be negative or zero");
        }
        if(bookTicketRequestDTO.getShowId()<=0){
            throw new InvalidBookTicketRequestException("Invalid show.show cannot be negative or zero");
        }

        if(bookTicketRequestDTO.getShowSeatIds()==null || bookTicketRequestDTO.getShowSeatIds().isEmpty()){
            throw new InvalidBookTicketRequestException("Invalid show.show cannot be negative or zero");
        }
    }

}
