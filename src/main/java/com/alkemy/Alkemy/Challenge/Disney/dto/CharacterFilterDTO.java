package com.alkemy.Alkemy.Challenge.Disney.dto;

import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterFilterDTO {

    private Integer age;
    private String name;
    private Set<MovieEntity> movies;

}