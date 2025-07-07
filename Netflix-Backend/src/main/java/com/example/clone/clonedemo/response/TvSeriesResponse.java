package com.example.clone.clonedemo.response;

import java.util.List;

import com.example.clone.clonedemo.entity.TvSeries;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TvSeriesResponse {
    @JsonProperty("page")
    private int page;
    @JsonProperty("results")
    private List<TvSeries> tvSeries;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    public TvSeriesResponse(int page, int totalPages, int totalResults, List<TvSeries> tvSeries) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.tvSeries = tvSeries;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TvSeries> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TvSeries> tvSeries) {
        this.tvSeries = tvSeries;
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
