package com.cinematograph.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Actor {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @DBRef(lazy = true)
    @JsonIgnoreProperties("actors")
    private Set<Movie> movies;

    private Double mark;

    private String imgURL;
}
