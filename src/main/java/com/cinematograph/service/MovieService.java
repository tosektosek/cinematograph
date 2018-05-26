package com.cinematograph.service;

import com.cinematograph.domain.Movie;
import com.cinematograph.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieService {


    void deleteById(String id);

    Movie findByTitle(String title);

    Movie save(Movie movie);

    List<Movie> getRandom();
}
