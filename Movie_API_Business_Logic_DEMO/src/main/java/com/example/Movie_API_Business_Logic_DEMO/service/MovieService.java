package com.example.Movie_API_Business_Logic_DEMO.service;

import com.example.Movie_API_Business_Logic_DEMO.entity.Movie;
import com.example.Movie_API_Business_Logic_DEMO.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        if(movie.getRating()<0 || movie.getRating()>10){
            throw new RuntimeException("Rating must be between 0 and 10.");
        }
        return movieRepository.save(movie);
    }
}
