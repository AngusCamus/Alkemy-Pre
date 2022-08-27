package com.alkemy.Alkemy.Challenge.Disney.dto;

import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter@Setter
public class GenreDTO {


    private Long id;
    private String name;
    private String image;
    private List<MovieEntity> movies;

}
