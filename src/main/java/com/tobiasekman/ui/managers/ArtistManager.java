package com.tobiasekman.ui.managers;

import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.ArtistInfo;

import static com.tobiasekman.ui.MyScanner.*;

import java.util.List;

public class ArtistManager {

    ArtistDao artistDao = new ArtistDao();

    public void showAllArtists() {

        List<Artist> artists = artistDao.getAll();
        artists.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        artists.forEach(System.out::println);

    }

    public void createArtist() {

        System.out.print("Name: ");
        String name = stringScanner();
        System.out.print("Full name: ");
        String fullName = stringScanner();
        System.out.print("Age: ");
        int age = intScanner();
        System.out.print("Bio: ");
        String bio = stringScanner();

        ArtistInfo artistInfo = new ArtistInfo(fullName, age, bio);
        Artist artist = new Artist(name, artistInfo);

        artistDao.add(artist);
    }

    public void updateArtist() {

        showAllArtists();

        System.out.print("ID to update: ");
        Artist artist = artistDao.findById(intScanner());
        System.out.print("Name: ");
        artist.setName(stringScanner());

        artistDao.update(artist);
    }

    public void deleteArtist() {

        System.out.print("Artist to delete: ");
        Artist artist = artistDao.findByName(stringScanner());

        artistDao.delete(artist);

    }

    public void showArtist() {

        System.out.print("Name: ");
        Artist artist = artistDao.findByName(stringScanner());
        System.out.println("  " + artist.getName());
        System.out.println("  Full name: " + artist.getArtistInfo().getFullName());
        System.out.println("  Age: " + artist.getArtistInfo().getAge());
        System.out.println("  " + artist.getArtistInfo().getBio());

    }

    public void updateArtistBio() {

        System.out.print("Name: ");
        Artist artist = artistDao.findByName(stringScanner());

        System.out.print("New bio: ");
        ArtistInfo bio = artist.getArtistInfo();
        bio.setBio(stringScanner());

        artist.setArtistInfo(bio);
        artistDao.update(artist);

    }


}
