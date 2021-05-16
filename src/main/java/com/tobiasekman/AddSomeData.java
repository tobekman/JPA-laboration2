package com.tobiasekman;

import com.tobiasekman.model.AlbumDao;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.GenreDao;
import com.tobiasekman.model.entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddSomeData {

    public static void main(String[] args) throws IOException {

        addGenres();
        addArtists();
        addAlbums();
        addSongs();

    }

    private static void addGenres() throws IOException {

        GenreDao genreDao = new GenreDao();

        BufferedReader artistReader = Files.newBufferedReader(Paths.get("src/main/resources/genres.csv"));

        String line;
        while ((line = artistReader.readLine()) != null) {

            genreDao.add(new Genre(line));

        }



    }

    private static void addArtists() throws IOException {

        ArtistDao artistDao = new ArtistDao();

        BufferedReader artistReader = Files.newBufferedReader(Paths.get("src/main/resources/artists.csv"));

        String line;
        while ((line = artistReader.readLine()) != null) {

            String[] column = line.split("-",4);

            Artist artist = new Artist();
            artist.setName(column[0]);
            ArtistInfo artistInfo = new ArtistInfo();
            artistInfo.setFullName(column[1]);
            artistInfo.setAge(Integer.parseInt(column[2]));
            artistInfo.setBio(column[3]);
            artist.setArtistInfo(artistInfo);

            artistDao.add(artist);

        }
    }

    private static void addAlbums() throws IOException {

        AlbumDao albumDao = new AlbumDao();
        ArtistDao artistDao = new ArtistDao();
        GenreDao genreDao = new GenreDao();

        BufferedReader artistReader = Files.newBufferedReader(Paths.get("src/main/resources/albums.csv"));

        String line;
        while ((line = artistReader.readLine()) != null) {

            String[] column = line.split("-",4);

            Artist artist = artistDao.findByName(column[0]);

            String title = column[1];

            int year = Integer.parseInt(column[2]);

            Album album = new Album(title, year);

            Genre genre = genreDao.findByName(column[3]);

            album.setArtist(artist);
            album.addGenre(genre);

            albumDao.add(album);
            genreDao.update(genre, album);
        }
    }

    private static void addSongs() throws IOException {

        AlbumDao albumDao = new AlbumDao();
        ArtistDao artistDao = new ArtistDao();

        BufferedReader artistReader = Files.newBufferedReader(Paths.get("src/main/resources/songs.csv"));

        String line;

        while ((line = artistReader.readLine()) != null) {

            String[] column = line.split("-",4);

            Artist artist = artistDao.findByName(column[0]);
            String title = column[1];
            int length = Integer.parseInt(column[2]);
            Song song = new Song(title, length, artist);
            Album album = albumDao.findByName(column[3]);

            albumDao.update(album, song);

        }

    }
}
