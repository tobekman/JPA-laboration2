package com.tobiasekman.ui.managers;

import com.tobiasekman.model.GenreDao;
import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.AlbumDao;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.Genre;
import com.tobiasekman.model.entities.Song;

import static com.tobiasekman.ui.MyScanner.*;

import java.util.List;

public class AlbumManager {

    AlbumDao albumDao = new AlbumDao();
    ArtistDao artistDao = new ArtistDao();
    GenreDao genreDao = new GenreDao();

    public void createAlbum() {

        System.out.print("Create album for artist: ");
        Artist artist = artistDao.findByName(stringScanner());

        System.out.print("Title: ");
        String title = stringScanner();

        System.out.print("Release year: ");
        int year = intScanner();

        Album album = new Album(title, year);

        System.out.print("Genre: ");

        Genre genre = genreDao.findByName(stringScanner());

        album.setArtist(artist);
        album.addGenre(genre);

        albumDao.add(album);

    }

    public void showAllAlbums() {

        List<Album> albums = albumDao.getAll();

        showAlbums(albums);

    }

    public void showAlbumsByArtist() {

        System.out.print("Artist: ");
        List<Album> albums = artistDao.findByName(stringScanner()).getAlbums();

        showAlbums(albums);
    }

    private void showAlbums(List<Album> albums) {
        for (Album album : albums) {

            System.out.println("\n  '" + album.getTitle() + "', " + album.getYear() +
                    "\n  " + album.getArtist().getName() +
                    "\n  " + album.getGenres());

        }

        System.out.println("");
    }

    public void showAlbumByName() {
        System.out.print("Title: ");
        Album album = albumDao.findByName(stringScanner());
        System.out.println("\n  " + album.getTitle() + ", " + album.getYear() +
                "\n" + "  " + album.getArtist().getName() + "\n" +
                "  " + album.getGenres() + "\n");

        int counter = 1;
        List<Song> songs = album.getSongs();
        for (Song song : songs) {

            System.out.println("  " + counter + ". " + song);
            counter++;

        }

    }

    public void deleteAlbum() {

        System.out.print("Title: ");
        Album album = albumDao.findByName(stringScanner());

        albumDao.delete(album);

    }


}
