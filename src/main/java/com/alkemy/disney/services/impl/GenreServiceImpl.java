package com.alkemy.Alkemy.Challenge.Disney.services.impl;

import com.alkemy.Alkemy.Challenge.Disney.dto.GenreDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.GenreEntity;
import com.alkemy.Alkemy.Challenge.Disney.mappers.GenreMapper;
import com.alkemy.Alkemy.Challenge.Disney.repositories.GenreRepository;
import com.alkemy.Alkemy.Challenge.Disney.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {


    @Autowired
    GenreMapper genreMapper;
    @Autowired
    GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO dto) {
        GenreEntity genreEntity = genreMapper.genreDTO2Entity(dto);
        GenreEntity genre = genreRepository.save(genreEntity);
        GenreDTO genreSaved = genreMapper.genreEntity2DTO(genre);
        return genreSaved;
    }
}
