package com.example.clone.clonedemo.response;

import java.util.List;

import com.example.clone.clonedemo.entity.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponse {
    @JsonProperty("page")
    private int pageNum ;
    @JsonProperty("results")
    private List<Movie> movies;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    public MovieResponse(int pageNum, int totalPages, int totalResults) {
        this.pageNum = pageNum;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }


}
