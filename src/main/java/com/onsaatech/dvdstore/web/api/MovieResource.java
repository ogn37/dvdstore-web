package com.onsaatech.dvdstore.web.api;

import com.onsaatech.dvdstore.entity.Movie;
import com.onsaatech.dvdstore.service.MovieServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieResource {
    private final MovieServiceInterface movieService;

    public MovieResource(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long movieNumber) {
        return movieService.getMovieById(movieNumber);
    }

    @PostMapping
    public Movie  add( @RequestBody Movie movie) {
        return movieService.registerMovie(movie);
    }

    @GetMapping
    public Iterable<Movie> list(){
        return movieService.getMovieList();
    }

}
