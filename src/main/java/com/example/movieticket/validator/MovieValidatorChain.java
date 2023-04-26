package com.example.movieticket.validator;

import com.example.movieticket.model.Movie;

public class MovieValidatorChain {
    private MovieValidator head;

    public MovieValidatorChain() {
        initialize();
    }

    private void initialize() {
        head = new StringValidator();
    }

    public void validate(Movie movie) throws Exception {
        head.validate(movie);
    }
}
