package com.alkemy.Alkemy.Challenge.Disney.controllers;

import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.CharacterUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.services.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterServiceImpl characterService;

    //RetrieveOne
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> findById(@PathVariable Long id){

        CharacterDTO character = characterService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(character);
    }
    //Retrieve all
    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> filterCharacters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Set<Long> movies
    ){
        List<CharacterBasicDTO> characters = characterService.getAllCharacters(name, age, movies);

        return ResponseEntity.status(HttpStatus.OK).body(characters);
    }


    //create
    @PostMapping
    public ResponseEntity<CharacterDTO> createCharacter(@RequestBody CharacterDTO dto){

        CharacterDTO dtoCreated = characterService.createCharacter(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoCreated);
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacterById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@RequestBody CharacterUpdateDTO dto, @PathVariable Long id){
        CharacterDTO dtoUpdated = characterService.updateCharacter(dto, id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtoUpdated);
    }





}
