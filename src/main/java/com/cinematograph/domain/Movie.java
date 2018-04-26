package com.cinematograph.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

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

    private LocalDate releaseDate;

    private String imgURL;

    private Double visualEffectsMark;

    private Double actingMark;

    private Double plotMark;

    private Double musicMark;

    private Double mark;

    @DBRef(lazy = true)
    @JsonIgnoreProperties("movies")
    private Set<Actor> actors;

    @DBRef(lazy = true)
    @JsonIgnoreProperties("movies")
    private Set<Director> directors;

    @DBRef(lazy = true)
    @JsonIgnoreProperties("movies")
    private Set<Writer> writers;




}
