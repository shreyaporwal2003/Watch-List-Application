package com.example.shrey.watchlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shrey.watchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
			Optional<Movie> findByTitle(String title);
}