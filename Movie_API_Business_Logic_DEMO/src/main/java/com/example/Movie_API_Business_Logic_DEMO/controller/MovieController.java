package com.example.Movie_API_Business_Logic_DEMO.controller;

import com.example.Movie_API_Business_Logic_DEMO.entity.Movie;
import com.example.Movie_API_Business_Logic_DEMO.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping
    public Movie addMovie(@Valid @RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
}
