package com.example.demo.film;

import com.example.demo.acteur.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService)
    {
        this.filmService = filmService;
    }

    @GetMapping("api/film/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id){

        return filmService.getFilm(id);

    }

    @GetMapping("api/film")
    public List<Film> getFilms(){

        return filmService.getFilms();

    }

    @PostMapping("api/film")
    public ResponseEntity<Film> registerNewFilm(@RequestBody Film newFilm)
    {
        filmService.addNewFilm(newFilm);
        return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
    }
}
