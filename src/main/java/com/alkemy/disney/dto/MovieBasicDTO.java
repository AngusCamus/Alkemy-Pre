package com.alkemy.disney.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter@Getter
public class MovieBasicDTO {

    private String image;
    private String title;
    @DateTimeFormat
    private LocalDate createDate;
}
