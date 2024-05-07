package com.onsaatech.dvdstore.web.controller;

import com.onsaatech.dvdstore.entity.Movie;
import com.onsaatech.dvdstore.service.MovieServiceInterface;
import com.onsaatech.dvdstore.web.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieServiceInterface movieService;

    public MovieController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }
   /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long movieNumber, Model model) {
        Movie movie = movieService.getMovieById(movieNumber);
        model.addAttribute("movie", movie);
        return "movie-details";
    }*/

    @PostMapping("/add")
    public String  addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setGenre(movieForm.getGenre());
        movie.setTitle(movieForm.getTitle());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }


}
