package com.alkemy.disney.dto;

import com.alkemy.disney.entities.CharacterEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
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
    private Long genreId;
}
