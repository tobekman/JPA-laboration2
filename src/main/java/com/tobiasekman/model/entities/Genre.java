package com.tobiasekman.model.entities;

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
    private List<Album> albums;

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

    public List<Album> getAlbums() {
        if(albums == null) {
            albums = new ArrayList<>();
        }
        return this.albums;
    }

    public void addAlbum(Album album) {
        getAlbums().add(album);
    }

    @Override
    public String toString() {
        return getGenre();
    }
}

