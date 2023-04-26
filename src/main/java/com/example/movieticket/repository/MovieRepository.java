package com.example.movieticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieticket.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}