package com.alkemy.Alkemy.Challenge.Disney.services;


import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;

import java.util.List;

public interface MovieService  {

    //create
    MovieDTO createMovie (MovieDTO dto);
    //retrieve one
    MovieDTO getOneById (Long id);
    //retrieve all
    List<MovieDTO> getAllMovies();
    //delete by id
    void deleteMovie(Long id);
    //update
    MovieDTO updateMovie(MovieUpdateDTO dto, Long id );

    List<MovieBasicDTO> getByFilter(String name, String genre, String order);
}
