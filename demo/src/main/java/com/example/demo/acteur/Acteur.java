package com.example.demo.acteur;
import com.example.demo.film.Film;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Acteur {

    @SequenceGenerator(
            name = "acteurs_sequence",
            sequenceName = "acteurs_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "acteurssequence"
    )

    @Id
    private long id;
    private String nom;
    private String prenom;

    //...
//    @ManyToOne
//    @JoinColumn(name="film_id", nullable=true)
//    private Film film;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Film> films;

    public Acteur() {

    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Acteur(long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
