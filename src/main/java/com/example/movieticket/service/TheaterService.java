package com.example.movieticket.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.example.movieticket.model.Theater;

public interface TheaterService {
	List<Theater> getAllTheater();
	void saveTheater(Theater movieticket);
	Theater getTheaterById(long id);
	void deleteTheaterById(long id);
	void deleteAllTheater();
	Page<Theater> findTheaterPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}