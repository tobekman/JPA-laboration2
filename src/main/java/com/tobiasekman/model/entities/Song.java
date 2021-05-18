package com.tobiasekman.model.entities;

import jakarta.persistence.*;

@Entity
public class Song implements Comparable<Song> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int length;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;

    public Song() {
    }

    public Song(String title, int length, Artist artist) {
        this.title = title;
        this.length = length;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getDuration() {
        int minutes = length / 60;
        int seconds = length % 60;

        return minutes + ":" + String.format("%02d", seconds);
    }

    @Override
    public String toString() {
        return title + ", " + getDuration();
    }

    @Override
    public int compareTo(Song s) {

        if(this.getLength() > s.getLength()) {
            return 1;
        } else if (this.getLength() < s.getLength()) {
            return -1;
        }
        return 0;
    }
}
