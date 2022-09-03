package com.alkemy.disney.services.impl;

import com.alkemy.disney.repositories.GenreRepository;
import com.alkemy.disney.services.GenreService;
import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entities.GenreEntity;
import com.alkemy.disney.mappers.GenreMapper;
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
