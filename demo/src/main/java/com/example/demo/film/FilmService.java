package com.example.demo.film;

import com.example.demo.acteur.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FilmService {

    private final FilmRepository filmRepository;
    private final ActeurRepository acteurRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, ActeurRepository acteurRepository)
    {
        this.filmRepository = filmRepository;
        this.acteurRepository = acteurRepository;
    }
    public List<Film> getFilms(){
        return filmRepository.findAll();


//                new Film(1, "Titanic", "film romantique", List.of(new Acteur(0, "DiCaprio", "Leonardo")))

    }

    public Optional<Film> getFilm(Long id){

        return filmRepository.findById(id);

    }

    public void addNewFilm(Film newFilm) {

        acteurRepository.saveAll(newFilm.getActeurs());
        filmRepository.save(newFilm);

    }
}
