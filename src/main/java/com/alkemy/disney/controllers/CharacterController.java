package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharacterBasicDTO;
<<<<<<< HEAD
=======
import com.alkemy.disney.dto.CharacterCreateDTO;
>>>>>>> test
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterUpdateDTO;
import com.alkemy.disney.services.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<CharacterBasicDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Set<Long> movies
    ){
        List<CharacterBasicDTO> characters = characterService.getAllCharacters(name, age, movies);

        return ResponseEntity.status(HttpStatus.OK).body(characters);
    }


    //create
    @PostMapping
    public ResponseEntity<CharacterDTO> createCharacter(@Valid @RequestBody CharacterCreateDTO dto){

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
    public ResponseEntity<CharacterDTO> updateCharacter(@Valid @RequestBody CharacterUpdateDTO dto, @PathVariable Long id){
        CharacterDTO dtoUpdated = characterService.updateCharacter(dto, id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtoUpdated);
    }





}
