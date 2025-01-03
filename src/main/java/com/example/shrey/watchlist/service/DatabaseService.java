package com.example.shrey.watchlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shrey.watchlist.entity.Movie;
import com.example.shrey.watchlist.repository.MovieRepository;

@Service
public class DatabaseService {


	@Autowired
	MovieRepository movieRepo;



	@Autowired
	RatingService ratingService;

	public boolean movieExists(String title) {
		Optional<Movie> movie = movieRepo.findByTitle(title);
		return movie.isPresent();
	}

	public void create(Movie movie) throws Exception {
		// TODO Auto-generated method stub
		if(movieExists(movie.getTitle())) {
			throw new Exception("Movie with title '" + movie.getTitle() + "' already exists.");
		}

		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating != null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
	}

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub

		return movieRepo.findAllByOrderByRatingDesc();
	}

	public Movie getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}

	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated = getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setComment(movie.getComment());
		toBeUpdated.setPriority(movie.getPriority());

		movieRepo.save(toBeUpdated);
	}

	public void delete(Integer id) {
		movieRepo.deleteById(id);
	}
	public void saveMovie(Movie movie) {
		movieRepo.save(movie); // Persist changes to the database
	}













}