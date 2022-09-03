package com.alkemy.disney.dto;

import com.alkemy.disney.entities.CharacterEntity;
import com.alkemy.disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
public class MovieCreateDTO {

    private String title;
    private String image;
    @DateTimeFormat
    private LocalDate creationDate;
    @Valid
    @Range(min=1,max=5)
    private Integer rating;
    private Set<CharacterCreateDTO> characters;
    private GenreCreateDTO genre;

}
