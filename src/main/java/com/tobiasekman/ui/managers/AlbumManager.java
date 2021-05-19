package com.tobiasekman.ui.managers;

import com.tobiasekman.model.AlbumDao;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.GenreDao;
import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.Genre;
import com.tobiasekman.model.entities.Song;

import java.util.List;

import static com.tobiasekman.ui.MyScanner.intScanner;
import static com.tobiasekman.ui.MyScanner.stringScanner;

public class AlbumManager {

    AlbumDao albumDao = new AlbumDao();
    ArtistDao artistDao = new ArtistDao();
    GenreDao genreDao = new GenreDao();

    public void createAlbum() {
        try {

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

        } catch (Exception e) {

            System.out.println("Couldn't find artist");

        }


    }

    public void showAllAlbums() {

        List<Album> albums = albumDao.getAll();

        showAlbums(albums);

    }

    public void showAlbumsByArtist() {
        try {

            System.out.print("Artist: ");
            List<Album> albums = artistDao.findByName(stringScanner()).getAlbums();

            showAlbums(albums);

        } catch (Exception e) {

            System.out.println("Couldn't find artist");

        }

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
        try {

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

        } catch (Exception e) {

            System.out.println("Couldn't find album");

        }


    }

    public void deleteAlbum() {
        try {

            System.out.print("Title: ");
            Album album = albumDao.findByName(stringScanner());
            Artist artist = artistDao.findByName(album.getArtist().getName());
            albumDao.delete(album);
            artist.removeAlbum(album);
            artistDao.update(artist);

        } catch (Exception e) {

            System.out.println("Couldn't find album");

        }


    }


}
