package com.cinematograph.controller;

import com.cinematograph.domain.Actor;
import com.cinematograph.repository.ActorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }
}
