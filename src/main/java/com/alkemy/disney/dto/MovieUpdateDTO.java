package com.alkemy.disney.dto;

import com.alkemy.disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class MovieUpdateDTO {

    private String title;
    private String image;
    @DateTimeFormat
    private LocalDate creationDate;
    private Integer rating;
    private GenreEntity genre;
}
