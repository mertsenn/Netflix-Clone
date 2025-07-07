package com.example.clone.clonedemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvSeries {
    @JsonProperty("adult")
    private boolean isAdult;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("id")
    private int id;

    @JsonProperty("original_country")
    private List<String> originCountry;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private float popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("first_air_date")
    private String releaseDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("vote_average")
    private float voteAverage;

    @JsonProperty("vote_count")
    private int voteCount;

    

    public TvSeries() {
    }



    public TvSeries(boolean isAdult, String backdropPath, List<Integer> genreIds, int id, List<String> originCountry,
            String originalLanguage, String originalName, String overview, float popularity, String posterPath,
            String releaseDate, String name, float voteAverage, int voteCount) {
        this.isAdult = isAdult;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.id = id;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.name = name;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }



    public boolean isAdult() {
        return isAdult;
    }



    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }



    public String getBackdropPath() {
        return backdropPath;
    }



    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }



    public List<Integer> getGenreIds() {
        return genreIds;
    }



    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public List<String> getOriginCountry() {
        return originCountry;
    }



    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }



    public String getOriginalLanguage() {
        return originalLanguage;
    }



    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }



    public String getOriginalName() {
        return originalName;
    }



    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }



    public String getOverview() {
        return overview;
    }



    public void setOverview(String overview) {
        this.overview = overview;
    }



    public float getPopularity() {
        return popularity;
    }



    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }



    public String getPosterPath() {
        return posterPath;
    }



    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }



    public String getReleaseDate() {
        return releaseDate;
    }



    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public float getVoteAverage() {
        return voteAverage;
    }



    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }



    public int getVoteCount() {
        return voteCount;
    }



    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    
    

}
