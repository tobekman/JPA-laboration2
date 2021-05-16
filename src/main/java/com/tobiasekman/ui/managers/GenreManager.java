package com.tobiasekman.ui.managers;

import com.tobiasekman.model.GenreDao;
import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Genre;

import static com.tobiasekman.ui.MyScanner.*;

import java.util.List;

public class GenreManager {

    GenreDao genreDao = new GenreDao();

    public void createGenre() {

        System.out.print("Genre: ");
        Genre genre = new Genre(stringScanner());
        genreDao.add(genre);

    }

    public void showAllGenres() {

        genreDao.getAll().forEach(System.out::println);

    }


    public void showAlbumsByGenre() {

        System.out.print("Genre: ");
        Genre genre = genreDao.findByName(stringScanner());

        List<Album> albums = genre.getAlbums();
        System.out.println("\n  - " + genre.getGenre() + " Albums -\n");

        for (Album album : albums) {

            System.out.println("  " + album.getTitle() + ", " + album.getYear() +
                    "\n" + "  " + album.getArtist().getName() + "\n" +
                    "  " + album.getGenres() + "\n");

        }

    }
}
