package com.alkemy.Alkemy.Challenge.Disney.services.impl;

import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieFilterDTO;
import com.alkemy.Alkemy.Challenge.Disney.repositories.specifications.MovieSpec;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import com.alkemy.Alkemy.Challenge.Disney.mappers.MovieMapper;
import com.alkemy.Alkemy.Challenge.Disney.repositories.MovieRepository;
import com.alkemy.Alkemy.Challenge.Disney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    MovieMapper movieMapper;
    MovieSpec movieSpec;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper, MovieSpec movieSpec) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.movieSpec = movieSpec;
    }

    @Override
    public MovieDTO createMovie(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO movieSaved = movieMapper.movieEntity2DTO(entitySaved, true);

        return movieSaved;
    }

    @Override
    public MovieDTO getOneById(Long id) {

        Optional<MovieEntity> optMovie = movieRepository.findById(id);
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
        MovieEntity entity = optMovie.get();
        MovieEntity entityUpdated = movieMapper.movieUpdateDTO2Entity(dto, entity);
        MovieDTO movieUpdated = movieMapper.movieEntity2DTO(entityUpdated, true);
        return movieUpdated;
    }

    @Override
    public List<MovieBasicDTO> getAllMovies(String name, String genre, String order) {
        MovieFilterDTO filterDTO = new MovieFilterDTO(name, genre, order);
        List<MovieEntity> moviesEntity = movieRepository.findAll(movieSpec.getByFilters(filterDTO));
        List<MovieBasicDTO> movies = movieMapper.movieEntityList2BasicDTOList(moviesEntity);

        return movies;
    }
}
