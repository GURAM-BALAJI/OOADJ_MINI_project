package com.example.movieticket.validator;

import com.example.movieticket.model.Movie;

public class StringValidator implements MovieValidator {
    private MovieValidator nextValidator;

    @Override
    public void setNextValidator(MovieValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(Movie movie) throws Exception {
        if (!isAlpha(movie.getMovieName())
                || !isAlpha(movie.getDirectorName())
                || !isAlpha(movie.getDistributerName())) {
            throw new Exception("All fields should contain only characters");
        }

        if (nextValidator != null) {
            nextValidator.validate(movie);
        }
    }

    private boolean isAlpha(String str) {
        return str != null && str.matches("^[a-zA-Z]+$");
    }
}
