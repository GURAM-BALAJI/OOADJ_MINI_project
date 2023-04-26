package com.example.movieticket.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.movieticket.model.Movie;
import com.example.movieticket.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovie() {
		return movieRepository.findAll();
	}

	@Override
	public void saveMovie(Movie Movie) {
		this.movieRepository.save(Movie);
	}

	@Override
	public Movie getMovieById(long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		Movie movieticket = null;
		if (optional.isPresent()) {
			movieticket = optional.get();
		} else {
			throw new RuntimeException(" Movie not found for id :: " + id);
		}
		return movieticket;
	}

	@Override
	public void deleteMovieById(long id) {
		this.movieRepository.deleteById(id);
	}

	@Override
	public void deleteAllMovies() {
		this.movieRepository.deleteAll();
	}

	@Override
	public Page<Movie> findMoviePaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.movieRepository.findAll(pageable);
	}
}