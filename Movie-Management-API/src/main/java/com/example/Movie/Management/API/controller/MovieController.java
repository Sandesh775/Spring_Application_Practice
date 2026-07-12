package com.example.Movie.Management.API.controller;

import com.example.Movie.Management.API.entity.Movie;
import com.example.Movie.Management.API.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // endpoints
    //POST
    @PostMapping
    public String addMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return "Movie Saved Successfully";
    }

    // GET
    @GetMapping
    public List<Movie> getallMovies(){
        return movieRepository.findAll();
    }

    //PUT
    @PutMapping
    public String updateMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return "Movie update successfully !";
    }

    // GET movie by ID
    @GetMapping("/{id}")
    public Movie getMovieByID(@PathVariable Long id){
        return movieRepository.findById(id).orElse(null);
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public String deleteMovieById(@PathVariable Long id){
        movieRepository.deleteById(id);
        return "Movie Deleted Successfully !";
    }
}
