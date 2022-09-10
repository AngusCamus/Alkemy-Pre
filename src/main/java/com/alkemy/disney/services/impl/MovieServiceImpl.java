package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entities.CharacterEntity;
import com.alkemy.disney.exception.EnumErrors;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mappers.CharacterMapper;
import com.alkemy.disney.mappers.GenreMapper;
import com.alkemy.disney.repositories.CharacterRepository;
import com.alkemy.disney.repositories.GenreRepository;
import com.alkemy.disney.repositories.specifications.MovieSpec;
import com.alkemy.disney.entities.MovieEntity;
import com.alkemy.disney.mappers.MovieMapper;
import com.alkemy.disney.repositories.MovieRepository;
import com.alkemy.disney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    //Movie
    MovieRepository movieRepository;
    MovieMapper movieMapper;
    MovieSpec movieSpec;

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
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO movieSaved = movieMapper.movieEntity2DTO(entitySaved, true);

        return movieSaved;
    }

    @Override
    public MovieDTO getById(Long id) {

        Optional<MovieEntity> optMovie = movieRepository.findById(id);
        if (!optMovie.isPresent()) {
            throw new ParamNotFound(EnumErrors.ID_MOVIE.getErrorMessage());
        }
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
        if(movieRepository.findById(id).isPresent()){
            movieRepository.deleteById(id);
        }else{
            throw new ParamNotFound(EnumErrors.ID_MOVIE.getErrorMessage());
        }

    }

    @Override
    public MovieDTO updateMovie(MovieUpdateDTO dto, Long id) {
        Optional<MovieEntity> optMovie = movieRepository.findById(id);
        MovieEntity entity = optMovie.get();
        MovieEntity entityUpdate = movieMapper.movieUpdateDTO2Entity(dto, entity);
        MovieEntity entityUpdated =movieRepository.save(entityUpdate);
        MovieDTO movieUpdated = movieMapper.movieEntity2DTO(entityUpdated, true);
        return movieUpdated;
    }

    @Override
    public List<MovieBasicDTO> getAllMovies(String title, String genre, String order) {
        MovieFilterDTO filterDTO = new MovieFilterDTO(title, genre, order);
        List<MovieEntity> moviesEntity = movieRepository.findAll(movieSpec.getByFilters(filterDTO));
        List<MovieBasicDTO> movies = movieMapper.movieEntityList2BasicDTOList(moviesEntity);

        return movies;
    }

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
            throw new ParamNotFound(EnumErrors.ID_MOVIE.getErrorMessage());
        }
        MovieEntity entity = optMovie.get();
        entity.addCharacter(this.findCharacterById(idCharacter));
        movieRepository.save(entity);
        MovieDTO movie = movieMapper.movieEntity2DTO(entity, true);

        return movie;
    }

    @Override
    public MovieDTO removeCharacter2Movie(Long idMovie, Long idCharacter) {

        MovieEntity movie = this.movieRepository.findById(idMovie).orElseThrow(
                () -> new ParamNotFound(EnumErrors.ID_MOVIE.getErrorMessage()));

        CharacterEntity character = this.characterRepository.findById(idCharacter).orElseThrow(
                () -> new ParamNotFound(EnumErrors.ID_CHARACTER.getErrorMessage()));


        movie.getCharacters().remove(character);
        movieRepository.save(movie);
        MovieDTO movieResult = movieMapper.movieEntity2DTO(movie, true);
        return movieResult;

    }
}