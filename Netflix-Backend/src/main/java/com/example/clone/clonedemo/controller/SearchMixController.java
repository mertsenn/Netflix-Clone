package com.example.clone.clonedemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.clonedemo.entity.SearchMixObject;
import com.example.clone.clonedemo.service.SearchMixService;


@RestController
@RequestMapping("api/search")
public class SearchMixController {

    private final SearchMixService searchMixService;

    public SearchMixController(SearchMixService searchMixService){
        this.searchMixService = searchMixService;
    }

    @GetMapping("/multi")
    public List<SearchMixObject> getMethodName(@RequestParam("name") String name) {
       return searchMixService.getSearchResults(name);
    }
    

}
