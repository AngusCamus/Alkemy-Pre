<<<<<<< HEAD
package com.alkemy.Alkemy.Challenge.Disney.dto;
=======
package com.alkemy.disney.dto;
>>>>>>> test


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFilterDTO {

    private String title;
    private String genreId;
<<<<<<< HEAD
    private String order;

    public MovieFilterDTO(String name, String genreId, String order) {
    }


    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
=======

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

>>>>>>> test
    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
