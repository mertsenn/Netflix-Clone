package com.example.clone.clonedemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_rating")
public class UserRating {

    @Id
    private int movieId;

    @Column(name = "user_rating")
    private int userRating;

    public UserRating() {
    }

    public UserRating(int movieId, int userRating) {
        this.movieId = movieId;
        this.userRating = userRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

}
