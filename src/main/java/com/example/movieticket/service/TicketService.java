package com.example.movieticket.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.example.movieticket.model.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();
	void saveTicket(Ticket movieticket);
	Ticket getTicketById(long id);
	void deleteTicketById(long id);
	void deleteAllTicket();
	Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}