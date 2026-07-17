package com.example.Movie_API_Business_Logic_DEMO.service;

import com.example.Movie_API_Business_Logic_DEMO.entity.Movie;
import com.example.Movie_API_Business_Logic_DEMO.exception.InvalidMovieException;
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

//    public Movie addMovie(Movie movie){
////        if(movie.getTitle().isBlank()){
////            throw new InvalidMovieException("Title can't be blank !");
////        }
////
////        if(movie.getRating()<0 || movie.getRating()>10){
////            throw new InvalidMovieException("Rating must be between 0 and 10.");
////        }
//        // Now we don't need checking validation here it is already done via Bean Validation : @Valid, @NotBlank @Min(0) @Max(10) ,,, in controller and entity
//        return movieRepository.save(movie);
//    }
    public Movie addMovie(Movie movie){

        if(movieRepository.existsByTitle(movie.getTitle())){
            throw new InvalidMovieException(
                    "Movie already exists."
            );
        }

        return movieRepository.save(movie);
    }
}
