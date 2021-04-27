package com.tobiasekman;

import com.tobiasekman.entity.Album;
import com.tobiasekman.entity.Artist;
import com.tobiasekman.entity.ArtistInfo;
import com.tobiasekman.entity.Genre;
import com.tobiasekman.model.ArtistDao;
import com.tobiasekman.model.GenreDao;

import java.util.ArrayList;
import java.util.List;

public class AddSomeData {

    public static void main(String[] args) {

        GenreDao genreDao = new GenreDao();
        ArtistDao artistDao = new ArtistDao();

        Genre genre1 = new Genre("Pop");
        Genre genre2 = new Genre("Rock");
        Genre genre3 = new Genre("Rap");
        Genre genre4 = new Genre("Soul");
        Genre genre5 = new Genre("Metal");
        Genre genre6 = new Genre("RnB");
        Genre genre7 = new Genre("EDM");

        genreDao.add(genre1);
        genreDao.add(genre2);
        genreDao.add(genre3);
        genreDao.add(genre4);
        genreDao.add(genre5);
        genreDao.add(genre6);
        genreDao.add(genre7);

        ArtistInfo madonnaInfo = new ArtistInfo("Madonna Louise Ciccone",
                63,
                "Singer, songwriter from Bay City, Michigan, USA");

        List<Genre> madonnaGenres = new ArrayList<>();
        madonnaGenres.add(genre1);
        madonnaGenres.add(genre2);

        Artist madonna = new Artist("Madonna", madonnaInfo, madonnaGenres);

        Album madonna1 = new Album("Madonna",1983);
        Album madonna2 = new Album("Like a Virgin",1984);
        Album madonna3 = new Album("Music",2000);
        Album madonna4 = new Album("American Life",2003);

        madonna.addAlbum(madonna1);
        madonna.addAlbum(madonna2);
        madonna.addAlbum(madonna3);
        madonna.addAlbum(madonna4);

        artistDao.add(madonna);

        ArtistInfo markoolioInfo = new ArtistInfo("Marko Kristian Lehtosalo",
                45,
                "Swedish-Finnish rapper, singer living in Stockholm");

        List<Genre> markoolioGenre = new ArrayList<>();
        markoolioGenre.add(genre3);
        markoolioGenre.add(genre1);

        Artist markoolio = new Artist("Markoolio", markoolioInfo, markoolioGenre);

        Album markoolio1 = new Album("Tjock och Lycklig", 2001);
        Album markoolio2 = new Album("Värsta Plattan", 2007);
        Album markoolio3 = new Album("Jag är Markoolio", 2012);

        markoolio.addAlbum(markoolio1);
        markoolio.addAlbum(markoolio2);
        markoolio.addAlbum(markoolio3);

        artistDao.add(markoolio);

        ArtistInfo metallicaInfo = new ArtistInfo("Metallica",
                40,
                "The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield " +
                        "and drummer Lars Ulrich," +
                        " and has been based in San Francisco for most of its career.");

        List<Genre> metallicaGenre = new ArrayList<>();
        metallicaGenre.add(genre5);

        Artist metallica = new Artist("Metallica", metallicaInfo, metallicaGenre);

        Album metallica1 = new Album("Kill 'Em All", 1983);
        Album metallica2 = new Album("Master of Puppets", 1986);
        Album metallica3 = new Album("Metallica", 1991);
        Album metallica4 = new Album("Reload", 1997);
        Album metallica5 = new Album("Hardwired... to Self-Destruct", 2016);

        metallica.addAlbum(metallica1);
        metallica.addAlbum(metallica2);
        metallica.addAlbum(metallica3);
        metallica.addAlbum(metallica4);
        metallica.addAlbum(metallica5);

        artistDao.add(metallica);

        ArtistInfo jayzInfo = new ArtistInfo("Shawn Corey Carter",
                52,
                "American rapper, songwriter, record executive, businessman, and record producer. " +
                        "He is widely regarded as one of the most influential hip-hop artists in history.");

        List<Genre> jayzGenre = new ArrayList<>();
        jayzGenre.add(genre3);

        Artist jayz = new Artist("Jay Z", jayzInfo, jayzGenre);

        Album jayz1 = new Album("Reasonable Doubt", 1996);
        Album jayz2 = new Album("Vol. 2... Hard Knock Life", 1998);
        Album jayz3 = new Album("The Blueprint", 2001);
        Album jayz4 = new Album("The Black Album", 2003);
        Album jayz5 = new Album("American Gangster", 2007);
        Album jayz6 = new Album("4:44", 2017);

        jayz.addAlbum(jayz1);
        jayz.addAlbum(jayz2);
        jayz.addAlbum(jayz3);
        jayz.addAlbum(jayz4);
        jayz.addAlbum(jayz5);
        jayz.addAlbum(jayz6);

        artistDao.add(jayz);


    }
}
