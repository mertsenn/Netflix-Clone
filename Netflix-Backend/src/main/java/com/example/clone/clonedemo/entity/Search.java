package com.example.clone.clonedemo.entity;

import java.util.List;

public class Search {

    private int page;
    private List<SearchMixObject> results;
    private int totalPages;
    private int totalResults;

    public Search() {
    }

    public Search(int page, List<SearchMixObject> results, int totalPages, int totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<SearchMixObject> getResults() {
        return results;
    }

    public void setResults(List<SearchMixObject> results) {
        this.results = results;
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
