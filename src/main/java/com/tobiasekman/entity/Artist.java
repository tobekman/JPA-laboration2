package com.tobiasekman.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private List<Album> albums;

    @OneToOne(cascade = CascadeType.ALL)
    private ArtistInfo artistInfo;



    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "artist_genre",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;


    public Artist() {

    }

    public Artist(String name, ArtistInfo artistInfo, List<Genre> genres) {
        this.name = name;
        this.artistInfo = artistInfo;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        if(albums == null) {
            albums = new ArrayList<>();
        }
        return this.albums;
    }

    public List<Genre> getGenres() {
        if(genres == null) {
            genres = new ArrayList<>();
        }
        return this.genres;
    }

    public void addAlbum(Album album) {
        getAlbums().add(album);
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + " - " +
                "Name: " + getName() + " - " +
                "Full name: " + artistInfo.getFullName() + " - " +
                "Age: " + artistInfo.getAge() + " - " +
                "Genre: " + getGenres() + " - " +
                "Bio: " + artistInfo.getBio() + "]";
    }
}
