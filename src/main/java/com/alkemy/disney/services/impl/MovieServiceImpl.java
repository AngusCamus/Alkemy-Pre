<<<<<<< HEAD
package com.alkemy.Alkemy.Challenge.Disney.services.impl;

import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import com.alkemy.Alkemy.Challenge.Disney.mappers.MovieMapper;
import com.alkemy.Alkemy.Challenge.Disney.repositories.MovieRepository;
import com.alkemy.Alkemy.Challenge.Disney.repositories.specifications.MovieSpec;
import com.alkemy.Alkemy.Challenge.Disney.services.MovieService;
=======
package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entities.CharacterEntity;
import com.alkemy.disney.entities.GenreEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.exception.RatingMovieValidator;
import com.alkemy.disney.mappers.CharacterMapper;
import com.alkemy.disney.mappers.GenreMapper;
import com.alkemy.disney.repositories.CharacterRepository;
import com.alkemy.disney.repositories.GenreRepository;
import com.alkemy.disney.repositories.specifications.MovieSpec;
import com.alkemy.disney.entities.MovieEntity;
import com.alkemy.disney.mappers.MovieMapper;
import com.alkemy.disney.repositories.MovieRepository;
import com.alkemy.disney.services.MovieService;
>>>>>>> test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> test

@Service
public class MovieServiceImpl implements MovieService {

<<<<<<< HEAD
=======
    //Movie
>>>>>>> test
    MovieRepository movieRepository;
    MovieMapper movieMapper;
    MovieSpec movieSpec;

<<<<<<< HEAD
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper, MovieSpec movieSpec) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.movieSpec = movieSpec;
    }

    @Override
    public MovieDTO createMovie(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
=======
    //Character
    CharacterServiceImpl characterService;
    CharacterRepository characterRepository;
    CharacterMapper characterMapper;
    //Genre
    GenreMapper genreMapper;
    GenreRepository genreRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper, MovieSpec movieSpec, CharacterServiceImpl characterService, CharacterRepository characterRepository, CharacterMapper characterMapper, GenreMapper genreMapper, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.movieSpec = movieSpec;
        this.characterService = characterService;
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
        this.genreMapper = genreMapper;
        this.genreRepository = genreRepository;
    }



    @Override
    public MovieDTO createMovie(MovieCreateDTO dto) {

        MovieEntity entity = movieMapper.movieCreateDTO2Entity(dto);
>>>>>>> test
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO movieSaved = movieMapper.movieEntity2DTO(entitySaved, true);

        return movieSaved;
    }

    @Override
<<<<<<< HEAD
    public MovieDTO getOneById(Long id) {

        Optional<MovieEntity> optMovie = movieRepository.findById(id);
=======
    public MovieDTO getById(Long id) {

        Optional<MovieEntity> optMovie = movieRepository.findById(id);
        if (!optMovie.isPresent()) {
            throw new ParamNotFound("Id movie not found");
        }
>>>>>>> test
        MovieEntity movieEntity = optMovie.get();
        MovieDTO movie = movieMapper.movieEntity2DTO(movieEntity, true);

        return movie;
    }

    @Override
    public List<MovieDTO> getAllMovies() {

        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, true);
        return result;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO updateMovie(MovieUpdateDTO dto, Long id) {
        Optional<MovieEntity> optMovie = movieRepository.findById(id);
<<<<<<< HEAD
        MovieEntity entity = optMovie.get();
        MovieEntity entityUpdated = movieMapper.movieUpdateDTO2Entity(dto, entity);
=======
        if (!optMovie.isPresent()) {
            throw new ParamNotFound("Id movie not found");
        }
        MovieEntity entity = optMovie.get();
        if( 5<dto.getRating() || dto.getRating() <1){
            throw new RatingMovieValidator("Rating provide is greater than 5 or less than 1");
        }
        MovieEntity entityUpdate = movieMapper.movieUpdateDTO2Entity(dto, entity);
        MovieEntity entityUpdated =movieRepository.save(entityUpdate);
>>>>>>> test
        MovieDTO movieUpdated = movieMapper.movieEntity2DTO(entityUpdated, true);
        return movieUpdated;
    }

    @Override
<<<<<<< HEAD
    public List<MovieBasicDTO> getByFilter(String name, String genre, String order) {
        MovieFilterDTO filterDTO = new MovieFilterDTO(name, genre, order);
=======
    public List<MovieBasicDTO> getAllMovies(String title, String genre, String order) {
        MovieFilterDTO filterDTO = new MovieFilterDTO(title, genre, order);
>>>>>>> test
        List<MovieEntity> moviesEntity = movieRepository.findAll(movieSpec.getByFilters(filterDTO));
        List<MovieBasicDTO> movies = movieMapper.movieEntityList2BasicDTOList(moviesEntity);

        return movies;
    }
<<<<<<< HEAD
}
=======

    @Override
    public CharacterEntity findCharacterById(Long id) {
        CharacterDTO characterDTO = characterService.getById(id);
        CharacterEntity character = characterService.characterMapper.characterDTO2Entity(characterDTO);
        return character;
    }

    @Override
    public MovieDTO addCharacter2Movie(Long idMovie, Long idCharacter) {

        Optional<MovieEntity> optMovie = movieRepository.findById(idMovie);
        if (!optMovie.isPresent()) {
            throw new ParamNotFound("Id movie not found");
        }
        MovieEntity entity = optMovie.get();
        entity.addCharacter(this.findCharacterById(idCharacter));
        movieRepository.save(entity);
        MovieDTO movie = movieMapper.movieEntity2DTO(entity, true);

        return movie;
    }

    @Override
    public MovieDTO removeCharacter2Movie(Long idMovie, Long idCharacter) {

        Optional<MovieEntity> optMovie = movieRepository.findById(idMovie);
        if (!optMovie.isPresent()) {
            throw new ParamNotFound("Id movie not found");
        }
        MovieEntity entity = optMovie.get();
        entity.delCharacter(idCharacter);
        movieRepository.save(entity);

        MovieDTO movie = movieMapper.movieEntity2DTO(entity, true);

        return movie;

    }
}
>>>>>>> test
