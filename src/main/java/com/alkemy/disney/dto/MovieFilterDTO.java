
package com.alkemy.disney.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private String genreId;

    private String order;


    public MovieFilterDTO(String title, String genre, String order) {
        this.title = title;
        this.genreId = genre;
        if (order == null){
            this.order = "ASC";
        }else{
            this.order = order;
        }

    }

    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
