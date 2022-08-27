package com.alkemy.Alkemy.Challenge.Disney.mappers;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.CharacterEntity;
import com.alkemy.Alkemy.Challenge.Disney.dto.entities.MovieEntity;
import com.alkemy.Alkemy.Challenge.Disney.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CharacterMapper {

    @Autowired
    CharacterRepository charRepository;
    @Autowired
    MovieMapper movieMapper;

    //E2DTO
    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies){


        CharacterDTO charDTO = new CharacterDTO();
        charDTO.setAge(entity.getAge());
        charDTO.setHistory(entity.getHistory());
        charDTO.setId(entity.getId());
        charDTO.setImage(entity.getImage());
        charDTO.setWeight(entity.getWeight());
        charDTO.setName(entity.getName());
        if (loadMovies){
            Set<MovieDTO> movieDTOs = movieMapper.movieEntitySet2DTOSet(entity.getMovies(), false);
            Set<MovieEntity> movies = movieMapper.movieDTOSet2EntitySet(movieDTOs);
            charDTO.setMovies(movies);
        }

        return charDTO;
    }
    //DTO2E
    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {

        CharacterEntity charEntity = new CharacterEntity();
        charEntity.setAge(dto.getAge());
        charEntity.setHistory(dto.getHistory());
        charEntity.setId(dto.getId());
        charEntity.setImage(dto.getImage());
        charEntity.setMovies(dto.getMovies());
        charEntity.setName(dto.getName());
        charEntity.setWeight(dto.getWeight());
        return charEntity;
    }


    //DTOList2Elist

    public List<CharacterEntity> characterDTO2Entity(List<CharacterDTO> dtos) {
        List<CharacterEntity> result = new ArrayList<>();
        for(CharacterDTO dto : dtos) {

            CharacterEntity charEntity = new CharacterEntity();
            charEntity.setAge(dto.getAge());
            charEntity.setHistory(dto.getHistory());
            charEntity.setId(dto.getId());
            charEntity.setImage(dto.getImage());
            charEntity.setMovies(dto.getMovies());
            charEntity.setName(dto.getName());
            charEntity.setWeight(dto.getWeight());
            result.add(charEntity);
        }
        return result;
    }


    //EList2DTOList
    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities){

        List<CharacterDTO> result = new ArrayList<>();
        for (CharacterEntity entity : entities){
            CharacterDTO charDTO = new CharacterDTO();
            charDTO.setAge(entity.getAge());
            charDTO.setHistory(entity.getHistory());
            charDTO.setId(entity.getId());
            charDTO.setImage(entity.getImage());
            charDTO.setMovies(entity.getMovies());
            charDTO.setWeight(entity.getWeight());
            charDTO.setName(entity.getName());
            result.add(charDTO);
        }
        return result;
    }
    //ESet2DTOSet
    public Set<CharacterDTO> characterEntitySet2DTOSet(Set<CharacterEntity> entities, boolean loadMovies){

        Set<CharacterDTO> result = new HashSet<>();
        for (CharacterEntity entity : entities){
            CharacterDTO charDTO = new CharacterDTO();
            charDTO.setAge(entity.getAge());
            charDTO.setHistory(entity.getHistory());
            charDTO.setId(entity.getId());
            charDTO.setImage(entity.getImage());
            charDTO.setWeight(entity.getWeight());
            charDTO.setName(entity.getName());
            result.add(charDTO);
            if (loadMovies){
                Set<MovieDTO> movieDTOs = movieMapper.movieEntitySet2DTOSet(entity.getMovies(), false);
                Set<MovieEntity> movies = movieMapper.movieDTOSet2EntitySet(movieDTOs);
                charDTO.setMovies(movies);
            }
        }
        return result;
    }

    //DTOSet2ESet
    public Set<CharacterEntity> characterDTOSet2EntitySet(Set<CharacterDTO> dtos){

        Set<CharacterEntity> result = new HashSet<>();
        for (CharacterDTO dto : dtos){
            CharacterEntity charEntity = new CharacterEntity();
            charEntity.setAge(dto.getAge());
            charEntity.setHistory(dto.getHistory());
            charEntity.setId(dto.getId());
            charEntity.setImage(dto.getImage());
            charEntity.setMovies(dto.getMovies());
            charEntity.setWeight(dto.getWeight());
            charEntity.setName(dto.getName());
            result.add(charEntity);
        }
        return result;
    }

    //UpdateDTO2E
    public CharacterEntity characterUpdateDTO2EntityUpdated(CharacterUpdateDTO dto, CharacterEntity entity){
        CharacterEntity entityUpdated = new CharacterEntity();
        entityUpdated.setImage(dto.getImage());
        entityUpdated.setName(dto.getName());
        entityUpdated.setWeight(dto.getWeight());
        entityUpdated.setMovies(entity.getMovies());
        entityUpdated.setHistory(dto.getHistory());
        entityUpdated.setId(entity.getId());
        entityUpdated.setAge(dto.getAge());

        return entityUpdated;
    }

    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> result = new ArrayList<>();
        for (CharacterEntity entity : entities){
            CharacterBasicDTO charDTO = new CharacterBasicDTO();
            charDTO.setImage(entity.getImage());
            charDTO.setName(entity.getName());
            result.add(charDTO);
        }
        return result;

    }
    //E2UpdateDTO
}
