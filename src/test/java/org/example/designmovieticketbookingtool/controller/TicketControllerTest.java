package org.example.designmovieticketbookingtool.controller;

import org.example.designmovieticketbookingtool.dtos.BookTicketResponseDTO;
import org.example.designmovieticketbookingtool.dtos.ResponseStatus;
import org.example.designmovieticketbookingtool.models.Ticket;
import org.example.designmovieticketbookingtool.service.TicketService;
import org.example.designmovieticketbookingtool.dtos.BookTicketRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TicketControllerTest {
    /*
     3 scenarios:
     1. Validation fails - -ve
     2. Ticket service fails - -ve
     3. Ticket service gives a ticket obj - +ve
     */
    @MockBean
    private TicketService ticketService;

    @Autowired
    private TicketController ticketController;

    @Test
    public void testBookTicket_ShowIdNegative() throws Exception {
        //Arrange
        BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
        requestDto.setShowId(-1);
        requestDto.setUserId(1);
        requestDto.setShowSeatIds(List.of(1,2,3,4));

        when(ticketService.generateTicket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowSeatIds())).thenThrow(RuntimeException.class);

        // Act
        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILED, responseDto.getResponse().getResponseStatus());
        assertNotNull(responseDto.getResponse().getMessage());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testBookTicket_UserIdNegative() throws Exception {
        //Arrange
        BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
        requestDto.setShowId(1);
        requestDto.setUserId(-1);
        requestDto.setShowSeatIds(List.of(1,2,3,4));

        when(ticketService.generateTicket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowSeatIds())).thenThrow(RuntimeException.class);

        // Act
        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILED, responseDto.getResponse().getResponseStatus());
        assertNotNull(responseDto.getResponse().getMessage());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    // TODO: Cover empty show seat ids and null show seat ids - covered below
    @Test
    public void testBookTicket_ShowSeatsIdNullNegative() throws Exception {
        //Arrange
        BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowSeatIds(null);

        when(ticketService.generateTicket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowSeatIds())).thenThrow(RuntimeException.class);

        // Act
        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILED, responseDto.getResponse().getResponseStatus());
        assertNotNull(responseDto.getResponse().getMessage());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    @Test
    public void testBookTicket_ShowSeatsIdEmptyNegative() throws Exception {
        //Arrange
        BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowSeatIds(List.of());

        when(ticketService.generateTicket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowSeatIds())).thenThrow(RuntimeException.class);

        // Act
        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILED, responseDto.getResponse().getResponseStatus());
        assertNotNull(responseDto.getResponse().getMessage());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
    }

    // Positive Test case

    @Test
    public void testBookTicket_Positive() throws Exception {
        //Arrange
        BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
        requestDto.setShowId(1);
        requestDto.setUserId(1);
        requestDto.setShowSeatIds(List.of(1,2,3,4));



        when(ticketService.generateTicket(requestDto.getUserId(),
                requestDto.getShowId(), requestDto.getShowSeatIds())).thenReturn(new Ticket());

        // Act
        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.SUCCESS, responseDto.getResponse().getResponseStatus());
        assertNull(responseDto.getResponse().getMessage());
        assertNotNull(responseDto.getTicket(), "Ticket should be generated");


    }
}