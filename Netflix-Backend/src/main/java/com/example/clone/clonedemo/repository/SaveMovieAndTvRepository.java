package com.example.clone.clonedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clone.clonedemo.entity.SavedMoviesAndTv;

@Repository
public interface SaveMovieAndTvRepository extends  JpaRepository<SavedMoviesAndTv, Integer> {

}
