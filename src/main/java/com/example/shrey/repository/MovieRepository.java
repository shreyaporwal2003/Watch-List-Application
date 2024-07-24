package com.example.shrey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shrey.watchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
