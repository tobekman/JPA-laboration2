package com.tobiasekman.ui.managers;

import com.tobiasekman.model.AlbumDao;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.SongDao;
import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.Song;
import java.util.List;

import static com.tobiasekman.ui.MyScanner.*;

public class SongManager {

    SongDao songDao = new SongDao();
    ArtistDao artistDao = new ArtistDao();
    AlbumDao albumDao = new AlbumDao();

    public void createSong() {

        System.out.print("Artist: ");
        Artist artist = artistDao.findByName(stringScanner());
        System.out.print("Title: ");
        String title = stringScanner();
        System.out.print("Length(seconds): ");
        int length = intScanner();
        Song song = new Song(title, length, artist);

        System.out.println("[1] Add song to album");
        System.out.println("[2] Single");

        if(intScanner() == 1) {
            System.out.print("Name of album: ");
            Album album = albumDao.findByName(stringScanner());
            song.setAlbum(album);
            album.addSong(song);
            albumDao.update(album);
        } else {
            songDao.add(song);
        }

    }

    public void deleteSong() {

        System.out.print("Song title: ");
        Song song = songDao.findByName(stringScanner());
        songDao.delete(song);
    }

    public void showAllSongs() {

        List<Song> songs = songDao.getAll();
        songs.sort((s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));
        songs.forEach(s -> System.out.println("  " + s));
    }

    public void showSongsByArtist() {

        System.out.print("Artist: ");
        List<Song> songs = songDao.findByArtist(stringScanner());
        songs.forEach(s -> System.out.println("  " + s));

    }
}
