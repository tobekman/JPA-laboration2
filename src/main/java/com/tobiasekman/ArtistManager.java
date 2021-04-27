package com.tobiasekman;

import com.tobiasekman.entity.Album;
import com.tobiasekman.entity.Artist;
import com.tobiasekman.entity.ArtistInfo;
import com.tobiasekman.entity.Genre;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.GenreDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtistManager {

    Scanner sc = new Scanner(System.in);
    ArtistDao artistDao = new ArtistDao();
    GenreDao genreDao = new GenreDao();

    public void showAllArtists() throws SQLException {

        artistDao.getArtists().forEach(System.out::println);

    }

    public void showAllAlbums() {

        artistDao.getArtists().forEach(a -> System.out.println("\n--- " + a.getName() + " ---" + "\n" + a.getAlbums()));

    }

    public void createArtist() {

        boolean loop = true;
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Full name: ");
        String fullName = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Bio: ");
        String bio = sc.nextLine();

        showAllGenres();
        System.out.println("- Add genre -");
        List<Genre> genres = new ArrayList<>();
        while (loop) {
            System.out.print("Id: ");
            genres.add(genreDao.getGenreById(sc.nextInt()));
            sc.nextLine();

            System.out.println("\nAdd one more?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice != 1) {
                loop = false;
            }

        }
        System.out.println(genres);

        ArtistInfo artistInfo = new ArtistInfo(fullName, age, bio);
        Artist artist = new Artist(name, artistInfo, genres);

        artistDao.add(artist);
    }

    public void updateArtist() throws SQLException {

        showAllArtists();

        System.out.print("ID to update: ");
        Artist artist = artistDao.findArtistById(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        artist.setName(sc.nextLine());

        artistDao.updateArtist(artist);
    }

    public void deleteArtistById() throws SQLException {

        showAllArtists();

        System.out.print("ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        artistDao.deleteArtist(id);

    }

    public void showArtist() throws SQLException {

        System.out.print("ID: ");
        Artist artist = artistDao.findArtistById(sc.nextInt());
        sc.nextLine();
        System.out.println(artist);
    }

    public void createAlbum() throws SQLException {

        showAllArtists();

        System.out.print("Create album for artist(id): ");
        int artistId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Release year: ");
        int year = sc.nextInt();
        sc.nextLine();
        Album album = new Album(title, year);

        artistDao.addAlbum(artistId, album);
    }

    public void createGenre() {

        System.out.print("Genre: ");
        Genre genre = new Genre(sc.nextLine());
        genreDao.add(genre);

    }

    public void showAllGenres() {

        genreDao.getGenres().forEach(System.out::println);

    }

    public void showArtistByGenre() {

        showAllGenres();
        System.out.print("Genre(id): ");
        Genre genre = genreDao.getGenreById(sc.nextInt());
        sc.nextLine();
        List<Artist> artists = genre.getArtists();
        System.out.println("\n- " + genre.getGenre() + " artists -");
        artists.forEach(a -> System.out.println(a.getName()));

    }

}
