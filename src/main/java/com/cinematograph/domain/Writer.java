package com.cinematograph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Writer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Set<Movie> movies;

    private Double rating;

    private String imgURL;
}
