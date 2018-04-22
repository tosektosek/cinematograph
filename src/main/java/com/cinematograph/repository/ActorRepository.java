package com.cinematograph.repository;

import com.cinematograph.domain.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
}
