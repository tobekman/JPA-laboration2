package com.tobiasekman.model;

import com.tobiasekman.model.entities.Album;
import com.tobiasekman.model.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenreDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("artist_management");

    public void add(Genre genre) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void update(Genre genre) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(genre);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Genre> getAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre g").getResultList();
        entityManager.close();
        return genres;

    }

    public Genre findById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.close();
        return genre;

    }

    public Genre findByName(String genreName) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Genre genre = (Genre) entityManager.createQuery("SELECT g FROM Genre g WHERE g.genre = :genre")
                .setParameter("genre", genreName)
                .getSingleResult();
        entityManager.close();
        return genre;

    }

}
