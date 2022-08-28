package com.alkemy.Alkemy.Challenge.Disney.mappers;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.entities.MovieEntity;
import com.alkemy.Alkemy.Challenge.Disney.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    //E2DTO
    public MovieDTO movieEntity2DTO (MovieEntity entity, boolean loadCharacters){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setGenre(entity.getGenre());
        movieDTO.setCreationDate(entity.getCreationDate());
        movieDTO.setImage(entity.getImage());
        movieDTO.setId(entity.getId());
        movieDTO.setRating(entity.getRating());
        movieDTO.setTitle(entity.getTitle());
        if (loadCharacters){
            Set<CharacterDTO> charDTOs = characterMapper.characterEntitySet2DTOSet(entity.getCharacters(), false);
            Set<CharacterEntity> characters = characterMapper.characterDTOSet2EntitySet(charDTOs);
            movieDTO.setCharacters(characters);
        }
        return movieDTO;
    }
    //DTO2E
    public MovieEntity movieDTO2Entity (MovieDTO dto){
        MovieEntity entity = new MovieEntity();
        entity.setCharacters(dto.getCharacters());
        entity.setGenre(dto.getGenre());
        entity.setCreationDate(dto.getCreationDate());
        entity.setImage(dto.getImage());
        entity.setRating(dto.getRating());
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());

        return entity;
    }
    //EList2DTOList
    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters){
        List<MovieDTO> dtos = new ArrayList<>();

        for(MovieEntity entity : entities) {
            dtos.add(movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }
    //DTOList2EList
    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtos){

        List<MovieEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtos) {
            entities.add(movieDTO2Entity(dto));
        }
        return entities;
    }
    //ESet2DTOSet
    public Set<MovieDTO> movieEntitySet2DTOSet(Set<MovieEntity> entities, boolean loadCharacters){
        Set<MovieDTO> dtos = new HashSet<>();

        for (MovieEntity entity : entities) {

            dtos.add(movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }
    //DTOSet2ESet
    public Set<MovieEntity> movieDTOSet2EntitySet(Set<MovieDTO> dtos){
        Set<MovieEntity> entities = new HashSet<>();

        for (MovieDTO dto : dtos) {
            entities.add(movieDTO2Entity(dto));
        }
        return entities;
    }
    //UpdateDTO2E
    public MovieEntity movieUpdateDTO2Entity(MovieUpdateDTO dto, MovieEntity entity){

        MovieEntity entityUpdated = new MovieEntity();
        entityUpdated.setGenre(dto.getGenre());
        entityUpdated.setCreationDate(dto.getCreationDate());
        entityUpdated.setImage(dto.getImage());
        entityUpdated.setRating(dto.getRating());
        entityUpdated.setTitle(dto.getTitle());
        entityUpdated.setId(entity.getId());
        entityUpdated.setCharacters(entity.getCharacters());

        return entityUpdated;
    }
    //E2UpdateDTO
    public MovieUpdateDTO movieEntity2UpdateDTO(MovieEntity entity){
        MovieUpdateDTO movieDTO = new MovieUpdateDTO();
        movieDTO.setGenre(entity.getGenre());
        movieDTO.setCreationDate(entity.getCreationDate());
        movieDTO.setImage(entity.getImage());
        movieDTO.setRating(entity.getRating());
        movieDTO.setTitle(entity.getTitle());

        return movieDTO;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> moviesEntity) {

        List<MovieBasicDTO> dtos = new ArrayList<>();

        for(MovieEntity entity : moviesEntity) {
            MovieBasicDTO movieDTO = new MovieBasicDTO();
            movieDTO.setImage(entity.getImage());
            movieDTO.setTitle(entity.getTitle());
            dtos.add(movieDTO);
        }
        return dtos;

    }
}
