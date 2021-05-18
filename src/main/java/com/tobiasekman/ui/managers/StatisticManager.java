package com.tobiasekman.ui.managers;

import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.GenreDao;
import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.Genre;
import com.tobiasekman.model.entities.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.tobiasekman.ui.MyScanner.*;

public class StatisticManager {

    ArtistDao artistDao = new ArtistDao();
    GenreDao genreDao = new GenreDao();

    public void artistStats() {

        System.out.print("Artist: ");
        Artist artist = artistDao.findByName(stringScanner());

        List<Album> albums = artist.getAlbums();
        List<Song> songs = artist.getSongs();

        Song longest;
        Song shortest;
        Album newest;
        Album oldest;

        if(albums.size() > 1 && songs.size() > 0) {

            newest = Collections.max(albums);
            oldest = Collections.min(albums);
            longest = Collections.max(songs);
            shortest = Collections.min(songs);

            System.out.println("\n  -" + artist.getName()+ "-" +
                    "\n  Albums: " + albums.size() +
                    "\n  First release: " + oldest.getTitle() + ", " + oldest.getYear() +
                    "\n  Latest release: " + newest.getTitle() + ", " +newest.getYear() +
                    "\n  Songs: " + songs.size() +
                    "\n  Longest song: " + longest.getTitle() + ", " + longest.getDuration() +
                    "\n  Shortest song: " + shortest.getTitle() + ", " + shortest.getDuration());

        } else if (albums.size() == 1) {

            System.out.println("\n  -" + artist.getName()+ "-" +
                    "\n  Album: " + albums.size() +
                    "\n  Released: " + albums.get(0).getYear());

            if(songs.size() > 0) {
                longest = Collections.max(songs);
                shortest = Collections.min(songs);

                System.out.println("\n  Songs: " + songs.size() +
                        "\n  Longest song: " + longest.getTitle() + ", " + longest.getDuration() +
                        "\n  Shortest song: " + shortest.getTitle() + ", " + shortest.getDuration());
            } else {
                System.out.println("  Songs: 0");
            }


        } else if (songs.size() > 0) {

            longest = Collections.max(songs);
            shortest = Collections.min(songs);

            System.out.println("\n  -" + artist.getName() + "-" +
                    "\n  Songs: " + songs.size()+
                    "\n  Longest song: " + longest.getTitle() + ", " + longest.getDuration() +
                    "\n  Shortest song: " + shortest.getTitle() + ", " + shortest.getDuration());

        } else {

            System.out.println("\n  " + artist.getName() + " doesn't have any albums or songs");

        }

    }

    public void genreStats() {

        List<Genre> genres = genreDao.getAll()
                .stream()
                .filter(s -> s.getAlbums().size() > 0)
                .sorted((g1, g2) -> g2.getAlbums().size() - g1.getAlbums().size())
                .toList();

        System.out.println("\nAmount of albums in each genre\n");
        genres.forEach(g -> System.out.println(g.getGenre() + ": " + g.getAlbums().size()));


    }

}
