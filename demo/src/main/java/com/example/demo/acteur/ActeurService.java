package com.example.demo.acteur;

import com.example.demo.film.Film;
import com.example.demo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActeurService {

    private final ActeurRepository acteurRepository;

    @Autowired
    public ActeurService(ActeurRepository acteurRepository)
    {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> getActeurs(){
        return acteurRepository.findAll();


//                new Film(1, "Titanic", "film romantique", List.of(new Acteur(0, "DiCaprio", "Leonardo")))

    }
}
