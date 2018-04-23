package com.cinematograph.repository;

import com.cinematograph.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "movie", collectionResourceRel = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findByTitle(String title);
}
