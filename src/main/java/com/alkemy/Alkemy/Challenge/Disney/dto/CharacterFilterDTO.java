package com.alkemy.Alkemy.Challenge.Disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterFilterDTO {

    private Integer age;
    private String name;
    private Set<Long> movies;

    public CharacterFilterDTO(Integer age, String name, Set<Long> movies) {
        this.age = age;
        this.name = name;
        this.movies = movies;
    }

}