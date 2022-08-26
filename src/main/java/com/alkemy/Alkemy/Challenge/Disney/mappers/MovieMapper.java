package com.alkemy.Alkemy.Challenge.Disney.mappers;

import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import com.alkemy.Alkemy.Challenge.Disney.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    MovieRepository movieRepository;

    //E2DTO
    public MovieDTO movieEntity2DTO (MovieEntity entity){}
    //DTO2E
    public MovieEntity movieDTO2Entity (MovieDTO dto){}
    //EList2DTOList
    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities){}
    //DTOList2EList
    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtos){}
    //ESet2DTOSet
    public Set<MovieDTO> movieEntitySet2DTOSet(Set<MovieEntity> entities){}
    //DTOSet2ESet
    public Set<MovieEntity> movieDTOSet2EntitySet(Set<MovieDTO> dtos){}
    //UpdateDTO2E
    public MovieEntity movieUpdateDTO2Entity(MovieUpdateDTO dto){}
    //E2UpdateDTO
    public MovieUpdateDTO movieEntity2UpdateDTO(MovieEntity entity){}
}
