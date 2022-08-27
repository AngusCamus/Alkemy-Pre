package com.alkemy.Alkemy.Challenge.Disney.controllers;

import com.alkemy.Alkemy.Challenge.Disney.dto.MovieBasicDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieDTO;
import com.alkemy.Alkemy.Challenge.Disney.dto.MovieUpdateDTO;
import com.alkemy.Alkemy.Challenge.Disney.services.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //Retrieve One
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){

        MovieDTO movie = movieService.getOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    //Retrieve List
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String order
        ){

        List<MovieBasicDTO> moviesDTO = movieService.getByFilter(name,genre,order);

        return ResponseEntity.status(HttpStatus.OK).body(moviesDTO);
    }
    //Create
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO dto){

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
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieUpdateDTO dto, @PathVariable Long id){

        MovieDTO movieUpdated = movieService.updateMovie(dto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieUpdated);
    }

}
