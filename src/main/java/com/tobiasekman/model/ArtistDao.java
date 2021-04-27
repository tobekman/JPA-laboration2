package com.tobiasekman.model;

import com.tobiasekman.entity.Album;
import com.tobiasekman.entity.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ArtistDao {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("artist_management");


    public void add(Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Artist> getArtists() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Artist> artists = entityManager.createQuery("SELECT a FROM Artist a").getResultList();
        entityManager.close();
        return artists;

    }

    public void updateArtist(Artist artist) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist updatedArtist = entityManager.find(Artist.class, artist.getId());
        updatedArtist.setName(artist.getName());
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void addAlbum(int id, Album album) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist updatedArtist = entityManager.find(Artist.class, id);
        updatedArtist.addAlbum(album);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    public void deleteArtist(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Artist findArtistById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.close();
        return artist;

    }

}
