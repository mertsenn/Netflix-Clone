package com.example.clone.clonedemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genres {
    
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    
}
