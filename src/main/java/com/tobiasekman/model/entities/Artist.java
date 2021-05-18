package com.tobiasekman.model.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> albums;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs;

    @OneToOne(cascade = CascadeType.ALL)
    private ArtistInfo artistInfo;


    public Artist() {

    }

    public Artist(String name, ArtistInfo artistInfo ) {
        this.name = name;
        this.artistInfo = artistInfo;
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

    public void setArtistInfo(ArtistInfo artistInfo) {
        this.artistInfo = artistInfo;
    }

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }

    public List<Album> getAlbums() {
        if(albums == null) {
            albums = new ArrayList<>();
        }
        return this.albums;
    }

    public List<Song> getSongs() {
        if(songs == null) {
            songs = new ArrayList<>();
        }
        return this.songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addAlbum(Album album) {
        getAlbums().add(album);
    }

    public void addSong(Song song) {
        getSongs().add(song);
    }

    public void removeAlbum(Album album) {
    getAlbums().remove(album);
    }

    public void removeSong(Song song) {
        getSongs().remove(song);
    }

    @Override
    public String toString() {
        return "  ID: " + getId() + " - " +
                "Name: " + getName();

    }
}
