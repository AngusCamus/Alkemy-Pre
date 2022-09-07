package com.alkemy.disney.dto;

import com.alkemy.disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.time.LocalDate;

@Getter
@Setter
public class MovieUpdateDTO {

    @Length(max = 30)
    private String title;
    private String image;
    @DateTimeFormat
    private LocalDate creationDate;
    @Range(min=1, max=5)
    private Integer rating;
}
