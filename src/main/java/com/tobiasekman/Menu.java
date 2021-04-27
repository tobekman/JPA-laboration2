package com.tobiasekman;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static ArtistManager am = new ArtistManager();


    public static void menu() throws SQLException {
        boolean loop = true;
        System.out.println("-Artist management-");

        while (loop) {
            System.out.println("\n[1] Show all artists");
            System.out.println("[2] Create artist");
            System.out.println("[3] Update artist");
            System.out.println("[4] Delete artist");
            System.out.println("[5] Show artist");
            System.out.println("[6] Create album");
            System.out.println("[7] Show all albums");
            System.out.println("[8] Add a genre");
            System.out.println("[9] Show all genres");
            System.out.println("[10] Show artists by genre");
            System.out.println("[0] Exit");


            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    am.showAllArtists();
                    break;
                case 2:
                    am.createArtist();
                    break;
                case 3:
                    am.updateArtist();
                    break;
                case 4:
                    am.deleteArtistById();
                    break;
                case 5:
                    am.showArtist();
                    break;
                case 6:
                    am.createAlbum();
                    break;
                case 7:
                    am.showAllAlbums();
                    break;
                case 8:
                    am.createGenre();
                    break;
                case 9:
                    am.showAllGenres();
                    break;
                case 10:
                    am.showArtistByGenre();
                    break;
                default:
                    loop = false;
                    break;
            }
        }

    }

}
