package com.example.shrey.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.shrey.watchlist.entity.Movie;
import com.example.shrey.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {

	@Autowired
	DatabaseService databaseService;
	@GetMapping("/")
	public ModelAndView showHomePage() {
		String viewName="index";
		Map<String,Object> model=new HashMap<>();
		return new ModelAndView(viewName,model);
	}
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required=false) Integer id) {
		System.out.println(id);
		String viewName="watchlistItemForm";
		Map<String,Object> model =new HashMap<>();
		if(id == null) {
			model.put("watchlistItem", new Movie());
		} else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}


		return new ModelAndView(viewName, model);
	}

	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			//if errors are there, redisplay the form and let user enter again
			return new  ModelAndView("watchlistItemForm");
		}

		Integer id= movie.getId();
		try {
			if (id == null) {
				databaseService.create(movie);
			} else {
				databaseService.update(movie, id);
			}
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("watchlistItemForm");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}



		RedirectView  rd=new RedirectView();
		rd.setUrl("/watchlist");

		return  new ModelAndView(rd);

	}
	@GetMapping("/watchlist")
public ModelAndView getWatchlist() {
    String viewName = "watchlist";
    Map<String, Object> model = new HashMap<>();
    List<Movie> movieList = databaseService.getAllMovies(); // Ensure `trailerUrl` is included here
    model.put("watchlistrows", movieList);
    model.put("noofmovies", movieList.size());
    return new ModelAndView(viewName, model);
}


	@GetMapping("/deleteItem")
	public RedirectView deleteMovie(@RequestParam Integer id) {
		databaseService.delete(id);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("/watchlist");
		return redirectView;
	}









}