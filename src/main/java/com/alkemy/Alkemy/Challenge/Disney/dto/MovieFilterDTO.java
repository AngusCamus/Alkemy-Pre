package com.alkemy.Alkemy.Challenge.Disney.dto;


import com.alkemy.Alkemy.Challenge.Disney.dto.entities.GenreEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private String genre;
    private String order;

    public MovieFilterDTO(String name, String genre, String order) {
    }


    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
