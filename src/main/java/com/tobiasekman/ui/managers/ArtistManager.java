package com.tobiasekman.ui.managers;

import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.ArtistInfo;

import java.util.List;

import static com.tobiasekman.ui.MyScanner.intScanner;
import static com.tobiasekman.ui.MyScanner.stringScanner;

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

        try {
            System.out.print("Artist to update: ");
            Artist artist = artistDao.findByName(stringScanner());
            System.out.print("Name: ");
            artist.setName(stringScanner());

            artistDao.update(artist);
        } catch (Exception e) {
            System.out.println("Couldn't find artist");
        }

    }

    public void deleteArtist() {
        try {
            System.out.print("Artist to delete: ");
            Artist artist = artistDao.findByName(stringScanner());

            artistDao.delete(artist);
        } catch (Exception e) {
            System.out.println("Couldn't find artist");
        }


    }

    public void showArtist() {

        try {
            System.out.print("Name: ");
            Artist artist = artistDao.findByName(stringScanner());
            System.out.println("  " + artist.getName());
            System.out.println("  Full name: " + artist.getArtistInfo().getFullName());
            System.out.println("  Age: " + artist.getArtistInfo().getAge());
            System.out.println("  " + artist.getArtistInfo().getBio());
        } catch (Exception e) {
            System.out.println("Couldn't find artist");
        }


    }

    public void updateArtistBio() {
        try {
            System.out.print("Name: ");
            Artist artist = artistDao.findByName(stringScanner());

            System.out.print("New bio: ");
            ArtistInfo bio = artist.getArtistInfo();
            bio.setBio(stringScanner());

            artist.setArtistInfo(bio);
            artistDao.update(artist);
        } catch (Exception e) {
            System.out.println("Couldn't find artist");
        }


    }


}
