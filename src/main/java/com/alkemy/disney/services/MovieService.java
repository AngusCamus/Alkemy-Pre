package com.alkemy.disney.services;


import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;

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

    List<MovieBasicDTO> getAllMovies(String name, String genre, String order);

    MovieDTO addCharacter2Movie(Long id, Long idCharacter);
}
