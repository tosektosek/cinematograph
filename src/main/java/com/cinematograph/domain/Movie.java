package com.cinematograph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private String id;

    private String title;

    private Set<String> genres;

    private Double rating;

    private LocalDate releaseDate;

    private Set<Actor> actors;

    private Set<Director> directors;

    private Set<Writer> writers;

    private String imgURL;


}
