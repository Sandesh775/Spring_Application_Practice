package com.example.Movie_API_Business_Logic_DEMO.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Movie title cannot be empty")
    private String title;
//    @Min(0)
//    @Max(10)
@Min(
        value = 0,
        message = "Rating cannot be negative."
)
@Max(
        value = 10,
        message = "Rating cannot exceed 10."
)
// we can write our own custom messages in bean validation annotations
    private double rating;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
