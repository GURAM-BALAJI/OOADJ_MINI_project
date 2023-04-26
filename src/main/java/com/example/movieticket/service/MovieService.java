package com.example.movieticket.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.example.movieticket.model.Movie;

public interface MovieService {
	List<Movie> getAllMovie();
	void saveMovie(Movie movieticket);
	Movie getMovieById(long id);
	void deleteMovieById(long id);
	void deleteAllMovies();
	Page<Movie> findMoviePaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}