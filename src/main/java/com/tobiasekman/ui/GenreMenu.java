package com.tobiasekman.ui;

import com.tobiasekman.ui.managers.GenreManager;

public class GenreMenu {

    public static void menu() {

        GenreManager gm = new GenreManager();

        boolean loop = true;
        System.out.println("-Manage Genre-");

        while (loop) {
            System.out.println("\n[1] Add a genre");
            System.out.println("[2] Show all genres");
            System.out.println("[3] Show albums by genre");

            System.out.println("[0] Back");

            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> gm.createGenre();
                case 2 -> gm.showAllGenres();
                case 3 -> gm.showAlbumsByGenre();

                default -> loop = false;
            }
        }
    }
}
