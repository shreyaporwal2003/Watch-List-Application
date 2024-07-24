package com.example.shrey.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shrey.repository.MovieRepository;
import com.example.shrey.watchlist.entity.Movie;

@Service
public class DatabaseService {
	
	@Autowired
	
	MovieRepository movieRepo;
	public void create(Movie movie) {
		
		movieRepo.save(movie);
		
	}
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
		
	}
	public Movie getMovieById(Integer id) {
		return movieRepo.findById(id).get();
		
	}
	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated=getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setComment(movie.getComment());
		toBeUpdated.setPriority(movie.getPriority());
		
		movieRepo.save(toBeUpdated);
		
		
	}

}
