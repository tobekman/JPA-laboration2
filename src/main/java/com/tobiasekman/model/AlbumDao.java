package com.tobiasekman.model;

import com.tobiasekman.model.entities.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AlbumDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("artist_management");

    public void add(Album album) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Album> getAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Album> albums = entityManager.createQuery("SELECT a FROM Album a").getResultList();
        entityManager.close();
        return albums;

    }

    public void update(Album album) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void delete(Album album) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(album));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Album findByName(String name) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Album album = (Album) entityManager.createQuery("SELECT a FROM Album a WHERE a.title = :name")
                .setParameter("name", name)
                .getSingleResult();
        entityManager.close();
        return album;

    }
}
