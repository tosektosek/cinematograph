package com.cinematograph.controller;

import com.cinematograph.domain.Movie;
import com.cinematograph.repository.MovieRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);
    }

    @PostMapping
    public Movie  addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PatchMapping("/{title}")
    public Movie updateMovie(@PathVariable String title, @RequestBody Movie movie) {
        movie.setId(movieRepository.findByTitle(title).getId());
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieRepository.deleteById(id);

    }
}
