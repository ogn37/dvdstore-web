package com.onsaatech.dvdstore.web.controller;

import com.onsaatech.dvdstore.service.MovieServiceInterface;
import com.onsaatech.dvdstore.web.form.MovieForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    private final MovieServiceInterface movieService;

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/dvdstore-home")
    public void displayHome(){

    }

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movieForm) {
        //movieService.addMovie(movie);
    }

}