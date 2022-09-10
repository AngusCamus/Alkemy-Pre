package com.alkemy.disney.mappers;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entities.CharacterEntity;
import com.alkemy.disney.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CharacterMapper {

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
            charDTO.setMovies(movieDTOs);
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
        charEntity.setMovies(movieMapper.movieDTOSet2EntitySet(dto.getMovies()));
        charEntity.setName(dto.getName());
        charEntity.setWeight(dto.getWeight());
        return charEntity;
    }


    //DTOList2Elist

    public List<CharacterEntity> characterDTO2Entity(List<CharacterDTO> dtos) {
        List<CharacterEntity> result = new ArrayList<>();
        for(CharacterDTO dto : dtos) {
            result.add(characterDTO2Entity(dto));
        }
        return result;
    }


    //EList2DTOList
    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovies){

        List<CharacterDTO> result = new ArrayList<>();
        for (CharacterEntity entity : entities){
            result.add(characterEntity2DTO(entity, loadMovies));
        }
        return result;
    }
    //ESet2DTOSet
    public Set<CharacterDTO> characterEntitySet2DTOSet(Set<CharacterEntity> entities, boolean loadMovies){

        Set<CharacterDTO> result = new HashSet<>();
        for (CharacterEntity entity : entities){
            result.add(characterEntity2DTO(entity, loadMovies));
        }
        return result;
    }

    //DTOSet2ESet
    public Set<CharacterEntity> characterDTOSet2EntitySet(Set<CharacterDTO> dtos){

        Set<CharacterEntity> result = new HashSet<>();
        for (CharacterDTO dto : dtos){
            result.add(characterDTO2Entity(dto));
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
        entityUpdated.setAge(dto.getAge());
        entityUpdated.setId(entity.getId());

        return entityUpdated;
    }

    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> result = new ArrayList<>();
        for (CharacterEntity entity : entities){
            result.add(characterEntity2BasicDTO(entity));
        }
        return result;

    }

    private CharacterBasicDTO characterEntity2BasicDTO(CharacterEntity entity) {
        CharacterBasicDTO charDTO = new CharacterBasicDTO();
        charDTO.setImage(entity.getImage());
        charDTO.setName(entity.getName());

        return charDTO;
    }

    public CharacterEntity characterCreateDTO2Entity(CharacterCreateDTO dto) {
        CharacterEntity entityNew = new CharacterEntity();
        entityNew.setImage(dto.getImage());
        entityNew.setName(dto.getName());
        entityNew.setWeight(dto.getWeight());
        entityNew.setHistory(dto.getHistory());
        entityNew.setAge(dto.getAge());

        return entityNew;
    }

    public List<CharacterEntity> characterCreateDTOSet2EntityList(Set<CharacterCreateDTO> dtos) {
        List<CharacterEntity> result = new ArrayList<>();
        for (CharacterCreateDTO dto : dtos){
            result.add(characterCreateDTO2Entity(dto));
        }
        return result;
    }

    public Set<CharacterEntity> characterEntityList2Set(List<CharacterEntity> charactersList) {

        Set<CharacterEntity> result = new HashSet<>();
        for (CharacterEntity entity : charactersList){
            result.add(entity);
        }
        return result;
    }

    public Set<CharacterEntity> characterCreateDTOSet2EntitySet(Set<CharacterCreateDTO> dtos) {
        Set<CharacterEntity> result = new HashSet<>();
        for (CharacterCreateDTO dto : dtos){
            result.add(characterCreateDTO2Entity(dto));
        }
        return result;

    }
}
