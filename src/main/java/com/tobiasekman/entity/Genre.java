package com.tobiasekman.entity;

import com.tobiasekman.entity.Artist;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String genre;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private List<Artist> artists;

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public List<Artist> getArtists() {
        if(artists == null) {
            artists = new ArrayList<>();
        }
        return this.artists;
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + getGenre();
    }
}

