package org.example.designmovieticketbookingtool.repository;

import org.example.designmovieticketbookingtool.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
