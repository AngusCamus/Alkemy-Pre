<<<<<<< HEAD
package com.alkemy.Alkemy.Challenge.Disney.services;


import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
=======
package com.alkemy.disney.services;


import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieCreateDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.entities.CharacterEntity;
>>>>>>> test

import java.util.List;

public interface MovieService  {

    //create
<<<<<<< HEAD
    MovieDTO createMovie (MovieDTO dto);
    //retrieve one
    MovieDTO getOneById (Long id);
=======
    MovieDTO createMovie (MovieCreateDTO dto);
    //retrieve one
    MovieDTO getById(Long id);
>>>>>>> test
    //retrieve all
    List<MovieDTO> getAllMovies();
    //delete by id
    void deleteMovie(Long id);
    //update
    MovieDTO updateMovie(MovieUpdateDTO dto, Long id );

<<<<<<< HEAD
    List<MovieBasicDTO> getByFilter(String name, String genre, String order);
=======
    List<MovieBasicDTO> getAllMovies(String name, String genre, String order);

    CharacterEntity findCharacterById(Long id);
    MovieDTO addCharacter2Movie(Long id, Long idCharacter);

    MovieDTO removeCharacter2Movie(Long id, Long idCharacter);
>>>>>>> test
}
