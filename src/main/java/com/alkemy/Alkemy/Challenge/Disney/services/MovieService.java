package com.alkemy.Alkemy.Challenge.Disney.services;


import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;

import java.util.List;

public interface MovieService  {

    //create
    MovieDTO createMovie (MovieDTO dto);
    //retrieve one
    MovieDTO getOneById (Long id);
    //retrieve all
    List<MovieDTO> getAllMovies();
    //delete by id
    MovieDTO deleteMovie(Long id);
    //update
    MovieDTO updateMovie(MovieUpdateDTO dto, Long id );
}
