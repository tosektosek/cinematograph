package com.cinematograph.repository;

import com.cinematograph.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
//@RepositoryRestResource(path = "movie", collectionResourceRel = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findByTitle(String title);
}
