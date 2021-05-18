package com.tobiasekman.model;

import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Artist;
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

    public List<Artist> getAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Artist> artists = entityManager.createQuery("SELECT a FROM Artist a").getResultList();
        entityManager.close();
        return artists;

    }

    public void update(Artist artist) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(artist);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void delete(Artist artist) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(artist));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Artist findById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.close();
        return artist;

    }

    public Artist findByName(String name) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Artist artist = (Artist) entityManager.createQuery("SELECT a FROM Artist a WHERE a.name = :name")
                .setParameter("name", name)
                .getSingleResult();
        entityManager.close();
        return artist;

    }

}
