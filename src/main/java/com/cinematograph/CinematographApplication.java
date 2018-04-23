package com.cinematograph;

import com.cinematograph.domain.Actor;
import com.cinematograph.domain.Movie;
import com.cinematograph.repository.ActorRepository;
import com.cinematograph.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CinematographApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CinematographApplication.class, args);
    }

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ActorRepository actorRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Actor actor = Actor.builder()
                .firstName("Leonardo")
                .lastName("DiCaprio")
                .rating(7.0)
                .build();

        Set<Actor> actors = new HashSet<>();
        actors.add(actor);
        actorRepository.save(actor);
        Movie movie = Movie.builder()
                .title("Inception")
                .releaseDate(LocalDate.of(2012, 4, 22))
                .rating(10.0)
                .actors(actors)
                .build();
        Set<Movie> movies = new HashSet<>();
        movies.add(movie);
        actor.setMovies(movies);

        movieRepository.deleteAll();
        actorRepository.deleteAll();
        movieRepository.save(movie);
        actorRepository.save(actor);
    }
}
