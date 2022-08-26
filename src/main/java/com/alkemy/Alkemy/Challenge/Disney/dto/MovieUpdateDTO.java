package com.alkemy.Alkemy.Challenge.Disney.dto;

import com.alkemy.Alkemy.Challenge.Disney.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.entities.GenreEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MovieUpdateDTO {

    private String title;
    private String image;
    @DateTimeFormat
    private LocalDate creationDate;
    private Integer rating;
    private GenreEntity genre;
}
