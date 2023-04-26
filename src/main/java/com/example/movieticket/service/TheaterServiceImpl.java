package com.example.movieticket.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.movieticket.model.Theater;
import com.example.movieticket.repository.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterRepository movieRepository;

	@Override
	public List<Theater> getAllTheater() {
		return movieRepository.findAll();
	}

	@Override
	public void saveTheater(Theater Theater) {
		this.movieRepository.save(Theater);
	}

	@Override
	public Theater getTheaterById(long id) {
		Optional<Theater> optional = movieRepository.findById(id);
		Theater movieticket = null;
		if (optional.isPresent()) {
			movieticket = optional.get();
		} else {
			throw new RuntimeException(" Theater not found for id :: " + id);
		}
		return movieticket;
	}

	@Override
	public void deleteTheaterById(long id) {
		this.movieRepository.deleteById(id);
	}
	@Override
	public void deleteAllTheater() {
		this.movieRepository.deleteAll();
	}

	@Override
	public Page<Theater> findTheaterPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.movieRepository.findAll(pageable);
	}
}