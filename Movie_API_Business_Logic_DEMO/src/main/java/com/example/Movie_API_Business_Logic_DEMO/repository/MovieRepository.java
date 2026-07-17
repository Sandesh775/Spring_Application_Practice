package com.example.Movie_API_Business_Logic_DEMO.repository;

import com.example.Movie_API_Business_Logic_DEMO.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long>
{

    boolean existsByTitle(String title);
}