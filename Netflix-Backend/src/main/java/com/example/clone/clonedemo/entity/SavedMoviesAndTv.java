package com.example.clone.clonedemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saved_movies")
public class SavedMoviesAndTv {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_adult")
    @JsonProperty("adult")
    private boolean isAdult;

    @Column(name = "backdrop_path")
    @JsonProperty("backdrop_path")
    private String backdropPath;

    @Column(name = "overview", length = 2000) // Tek bir "overview" kullanılıyor
    private String overview;

    @Column(name = "vote_average")
    @JsonProperty("vote_average")
    private double voteAverage;

    @Column(name = "user_rate", nullable = true)
    @JsonProperty("user_rate")
    private int userRate;



    public SavedMoviesAndTv() {
    }

    public SavedMoviesAndTv(int id, String title, boolean isAdult, String backdropPath, String overview,
            double voteAverage, int userRate) {
        this.id = id;
        this.title = title;
        this.isAdult = isAdult;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.userRate = userRate;
    }

    // Getter ve Setter'lar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getUserRate() {
        return userRate;
    }

    public void setUserRate(int userRate) {
        this.userRate = userRate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    

}
