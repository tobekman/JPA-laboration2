package com.tobiasekman.model.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album implements Comparable<Album> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int year;
    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "album_genre",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs;

    public Album() {

    }

    public Album(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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

    public void addSong(Song song) {
        getSongs().add(song);
    }

    public List<Genre> getGenres() {
        if(genres == null) {
            genres = new ArrayList<>();
        }
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        getGenres().add(genre);
    }

    @Override
    public String toString() {
        return getTitle() + ", " + getYear() + "\n  " + getGenres();
    }

    @Override
    public int compareTo(Album a) {
        if(this.getYear() > a.getYear()) {
            return 1;
        } else if (this.getYear() < a.getYear()) {
            return -1;
        }
        return 0;
    }
}
