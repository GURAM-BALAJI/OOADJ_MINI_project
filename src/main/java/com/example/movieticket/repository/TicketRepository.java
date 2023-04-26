package com.example.movieticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}