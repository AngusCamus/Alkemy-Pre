package com.alkemy.Alkemy.Challenge.Disney.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private String genreId;
    private String order;

    public MovieFilterDTO(String name, String genreId, String order) {
    }


    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
