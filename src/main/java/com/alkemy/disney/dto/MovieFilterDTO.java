package com.alkemy.disney.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private String genreId;

    private String order = "ASC";

    public MovieFilterDTO(String name, String genreId, String order) {
    }



    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
