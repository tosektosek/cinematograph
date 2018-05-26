package com.cinematograph.controller;

import com.cinematograph.domain.Movie;
import com.cinematograph.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/random")
    public List<Movie> getRandomMovie() {
        return movieService.getRandom();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PatchMapping("/{title}")
    public Movie updateMovie(@PathVariable String title, @RequestBody Movie movie) {
        movie.setId(movieService.findByTitle(title).getId());
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteById(id);
    }
}
