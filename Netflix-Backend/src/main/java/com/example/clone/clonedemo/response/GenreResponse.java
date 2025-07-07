package com.example.clone.clonedemo.response;

import java.util.List;

import com.example.clone.clonedemo.entity.Genres;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreResponse {
    @JsonProperty("genres")
    private List<Genres> genres;

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
    
    
}
