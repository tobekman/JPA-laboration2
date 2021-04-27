package com.tobiasekman.model;

import com.tobiasekman.entity.Genre;
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

    public List<Genre> getGenres() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre g").getResultList();
        entityManager.close();
        return genres;

    }

    public Genre getGenreById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.close();
        return genre;

    }

}
