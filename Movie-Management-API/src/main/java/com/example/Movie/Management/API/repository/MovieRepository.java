package com.example.Movie.Management.API.repository;

import com.example.Movie.Management.API.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
