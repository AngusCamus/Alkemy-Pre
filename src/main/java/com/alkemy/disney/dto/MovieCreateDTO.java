package com.alkemy.disney.dto;

import com.alkemy.disney.entities.CharacterEntity;
import com.alkemy.disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
public class MovieCreateDTO extends MovieUpdateDTO{

    private Set<CharacterCreateDTO> characters;
    @Positive
    @NotNull
    private Long genreId;

}
