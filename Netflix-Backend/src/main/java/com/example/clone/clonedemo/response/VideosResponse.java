package com.example.clone.clonedemo.response;

import java.util.List;

import com.example.clone.clonedemo.entity.MovieVideoResults;

public class VideosResponse {

    private String id;
    private List<MovieVideoResults> results;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<MovieVideoResults> getResults() {
        return results;
    }
    public void setResults(List<MovieVideoResults> results) {
        this.results = results;
    }
   
    

}
