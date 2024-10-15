package com.example.shrey.watchlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shrey.watchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
			Optional<Movie> findByTitle(String title);

			// Fetch all movies ordered by rating in descending order
			List<Movie> findAllByOrderByRatingDesc();
}