package com.example.movieticket.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.movieticket.model.Ticket;
import com.example.movieticket.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository movieticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return movieticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket Ticket) {
		this.movieticketRepository.save(Ticket);
	}

	@Override
	public Ticket getTicketById(long id) {
		Optional<Ticket> optional = movieticketRepository.findById(id);
		Ticket movieticket = null;
		if (optional.isPresent()) {
			movieticket = optional.get();
		} else {
			throw new RuntimeException(" Ticket not found for id :: " + id);
		}
		return movieticket;
	}

	@Override
	public void deleteTicketById(long id) {
		this.movieticketRepository.deleteById(id);
	}

	@Override
	public void deleteAllTicket() {
		this.movieticketRepository.deleteAll();
	}
	@Override
	public Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.movieticketRepository.findAll(pageable);
	}
}