package com.alkemy.Alkemy.Challenge.Disney.dto;

import com.alkemy.Alkemy.Challenge.Disney.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String title;
    private String image;
    @DateTimeFormat
    private LocalDate creationDate;
    private Integer rating;
    private Set<CharacterEntity> characters = new HashSet<>();
    private GenreEntity genre;
}
