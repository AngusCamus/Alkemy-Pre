package com.alkemy.Alkemy.Challenge.Disney.dto;


import com.alkemy.Alkemy.Challenge.Disney.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private GenreEntity genre;
    private String order;


    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
