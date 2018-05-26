package com.cinematograph;

import com.cinematograph.controller.MovieController;
import com.cinematograph.domain.Movie;
import com.cinematograph.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    private MovieController movieController;

    private Movie movie;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movieController = new MovieController(movieRepository, mongoTemplate);
        movie = Movie.builder().title("Movie").build();
    }

    @Test
    public void GetAllMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(Movie .builder().title("Avatar")
                .releaseDate(LocalDate.of(2009, 12, 25))
                .build());
        movies.add(Movie.builder().title("Titanic")
                .releaseDate(LocalDate.of(1998,2,13))
                .build());
        when(movieRepository.findAll()).thenReturn(movies);

        assertEquals(movies, movieController.getAllMovies());
    }

    @Test
    public void getMovieByTitle() {
        final String titanic = "Titanic";
        when(movieRepository.findByTitle(titanic))
                .thenReturn(Movie.builder().title(titanic).build());

        assertEquals(titanic, movieController.getMovieByTitle(titanic).getTitle());
    }

    @Test
    public void createMovie() {

        when(movieRepository.save(movie)).thenReturn(movie);

        assertEquals(movieController.addMovie(movie), movie);
        verify(movieRepository, times(1)).save(movie);
        verifyNoMoreInteractions(movieRepository);
    }

    @Test
    public void deleteMovie() {
        movieController.deleteMovie(movie.getId());
        verify(movieRepository, times(1)).deleteById(movie.getId());
    }
}
