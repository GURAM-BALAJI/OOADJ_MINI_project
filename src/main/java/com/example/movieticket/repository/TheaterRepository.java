package com.example.movieticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieticket.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long>{

}