package com.alkemy.Alkemy.Challenge.Disney.services.impl;

import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.mappers.MovieMapper;
import com.alkemy.Alkemy.Challenge.Disney.repositories.MovieRepository;
import com.alkemy.Alkemy.Challenge.Disney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;



    @Override
    public MovieDTO createMovie(MovieDTO dto) {
        return null;
    }

    @Override
    public MovieDTO getOneById(Long id) {
        return null;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return null;
    }

    @Override
    public MovieDTO deleteMovie(Long id) {
        return null;
    }

    @Override
    public MovieDTO updateMovie(MovieUpdateDTO dto, Long id) {
        return null;
    }
}
