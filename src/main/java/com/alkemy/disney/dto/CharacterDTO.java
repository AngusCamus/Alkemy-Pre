package com.alkemy.disney.dto;

import com.alkemy.disney.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterDTO {

    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;
    private Set<MovieEntity> movies = new HashSet<>();

}
