package com.example.movieticket.validator;

import com.example.movieticket.model.Movie;

public interface MovieValidator {
    void setNextValidator(MovieValidator nextValidator);

    void validate(Movie movie) throws Exception;
}
