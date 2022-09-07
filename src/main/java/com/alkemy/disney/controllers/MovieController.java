package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieCreateDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.services.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    //Retrieve One
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){

        MovieDTO movie = movieService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    //Retrieve List
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String order
        ){

        List<MovieBasicDTO> moviesDTO = movieService.getAllMovies(name,genre,order);

        return ResponseEntity.status(HttpStatus.OK).body(moviesDTO);
    }
    //Create
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieCreateDTO dto){

        MovieDTO movie = movieService.createMovie(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@Valid @RequestBody MovieUpdateDTO dto, @PathVariable Long id){

        MovieDTO movieUpdated = movieService.updateMovie(dto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieUpdated);
    }

    //Add Character
    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter){

        MovieDTO movieUpdated = movieService.addCharacter2Movie(idMovie, idCharacter);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieUpdated);
    }
    //Remove Character
    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDTO> removeCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter){

        MovieDTO movieUpdated = movieService.removeCharacter2Movie(idMovie, idCharacter);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieUpdated);
    }

}
