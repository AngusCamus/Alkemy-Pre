
package com.alkemy.disney.services;


import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieCreateDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.entities.CharacterEntity;

import java.util.List;

public interface MovieService  {

    //create
    MovieDTO createMovie (MovieCreateDTO dto);
    //retrieve one
    MovieDTO getById(Long id);
    //retrieve all
    List<MovieDTO> getAllMovies();
    //delete by id
    void deleteMovie(Long id);
    //update
    MovieDTO updateMovie(MovieUpdateDTO dto, Long id );

    List<MovieBasicDTO> getAllMovies(String name, String genre, String order);

    CharacterEntity findCharacterById(Long id);
    MovieDTO addCharacter2Movie(Long id, Long idCharacter);

    MovieDTO removeCharacter2Movie(Long id, Long idCharacter);
}
