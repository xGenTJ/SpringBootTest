package com.example.demo.film;

import com.example.demo.acteur.Acteur;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Film {

    @SequenceGenerator(
            name = "films_sequence",
            sequenceName = "films_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "filmssequence"
    )

    @Id
    private long id;
    private String titre;
    private String description;

//    @OneToMany(mappedBy = "film")
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Acteur> acteurs;

    public Film() {

    }

    public Film(long id, String titre, String description, List<Acteur> acteurs) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }

    public Film(String titre, String description, List<Acteur> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", acteurs=" + acteurs +
                '}';
    }

}
