package com.example.movieticket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.movieticket.model.Ticket;
import com.example.movieticket.model.Movie;
import com.example.movieticket.model.Theater;
import com.example.movieticket.service.TicketService;
import com.example.movieticket.service.MovieService;
import com.example.movieticket.service.TheaterService;
import com.example.movieticket.validator.MovieValidatorChain;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;

	private final MovieValidatorChain validatorChain = new MovieValidatorChain();

	// display list of tickets
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findTicketPaginated(1, "id", "asc", model);
	}

	@GetMapping("/showNewTicketForm")
	public String showNewTicketForm(Model model) {
		// create model attribute to bind form data
		Ticket Tickets = Ticket.getInstance();
		model.addAttribute("ticket", Tickets);
		return "new_ticket";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") Ticket movieticket) {
		// save movieticket to database
		ticketService.saveTicket(movieticket);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get movieticket from the service
		Ticket movieticket = ticketService.getTicketById(id);

		// set movieticket as a model attribute to pre-populate the form
		model.addAttribute("ticket", movieticket);
		return "update_ticket";
	}

	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") long id) {

		// call delete movieticket method
		this.ticketService.deleteTicketById(id);
		return "redirect:/";
	}

	@GetMapping("/ticketpage/{pageNo}")
	public String findTicketPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		Page<Ticket> page = ticketService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Ticket> listTickets = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listTickets", listTickets);
		return "index";
	}

	// display list of movies
	@GetMapping("/movie")
	public String viewMoviePage(Model model) {
		return findMoviePaginated(1, "id", "asc", model);
	}

	@GetMapping("/showNewMovieForm")
	public String showNewMovieForm(Model model) {
		// create model attribute to bind form data
		Movie Movies = Movie.getInstance();
		model.addAttribute("Movies", Movies);
		return "new_movie";
	}

	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("Movies") Movie movie, Model model) {
		try {
			validatorChain.validate(movie);
			movieService.saveMovie(movie);
			return "redirect:/movie";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "new_movie";
		}
	}

	@GetMapping("/showFormForMovieUpdate/{id}")
	public String showFormForMovieUpdate(@PathVariable(value = "id") long id, Model model) {
		// get movieticket from the service
		Movie movies = movieService.getMovieById(id);
		// set movieticket as a model attribute to pre-populate the form
		model.addAttribute("movies", movies);
		return "update_movie";
	}

	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable(value = "id") long id) {

		// call delete movieticket method
		this.movieService.deleteMovieById(id);
		return "redirect:/movie";
	}

	@GetMapping("/moviepage/{pageNo}")
	public String findMoviePaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		Page<Movie> page = movieService.findMoviePaginated(pageNo, pageSize, sortField, sortDir);
		List<Movie> listMovie = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listMovie", listMovie);
		return "movie";
	}

	// display list of movies
	@GetMapping("/Theater")
	public String viewTheaterPage(Model model) {
		return findTheaterPaginated(1, "id", "asc", model);
	}

	@GetMapping("/showNewTheaterForm")
	public String showNewTheaterForm(Model model) {
		// create model attribute to bind form data
		Theater Theaters = Theater.getInstance();
		model.addAttribute("Theaters", Theaters);
		return "new_theater";
	}

	@PostMapping("/saveTheater")
	public String saveTheater(@ModelAttribute("Theaters") Theater Theater) {
		// save Theater to database
		theaterService.saveTheater(Theater);
		return "redirect:/Theater";
	}

	@GetMapping("/showFormForTheaterUpdate/{id}")
	public String showFormForTheaterUpdate(@PathVariable(value = "id") long id, Model model) {
		// get movieticket from the service
		Theater theaters = theaterService.getTheaterById(id);
		// set movieticket as a model attribute to pre-populate the form
		model.addAttribute("theaters", theaters);
		return "update_theater";
	}

	@GetMapping("/deleteTheater/{id}")
	public String deleteTheater(@PathVariable(value = "id") long id) {
		// call delete theater method
		this.theaterService.deleteTheaterById(id);
		return "redirect:/Theater";
	}

	@GetMapping("/theaterpage/{pageNo}")
	public String findTheaterPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		Page<Theater> page = theaterService.findTheaterPaginated(pageNo, pageSize, sortField, sortDir);
		List<Theater> listTheater = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listTheater", listTheater);
		return "theater";
	}

	@GetMapping("/deleteAll")
	public String deleteAll() {
		this.theaterService.deleteAllTheater();
		this.ticketService.deleteAllTicket();
		this.movieService.deleteAllMovies();
		return "redirect:/";
	}
}