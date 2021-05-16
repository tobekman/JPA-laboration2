package com.tobiasekman.model;

import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Artist;
import com.tobiasekman.model.entities.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class SongDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("artist_management");

    public void add(Song song) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(song);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Song song) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(song));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Song> getAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Song> songs = entityManager.createQuery("SELECT s FROM Song s").getResultList();
        entityManager.close();
        return songs;
    }

    public Song findByName(String title) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (Song) entityManager.createQuery("SELECT s FROM Song s WHERE s.title = :title")
                .setParameter("title", title)
                .getSingleResult();
    }

    public List<Song> findByArtist(String artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Song> songs = entityManager.createQuery("SELECT s FROM Song s WHERE s.artist.name = :name")
                .setParameter("name", artist)
                .getResultList();
        entityManager.close();
        return songs;
    }

}
