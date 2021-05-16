package com.tobiasekman.ui;

public class MainMenu {

    public static void menu() {

        boolean loop = true;
        System.out.println("-Welcome to this amazing program-");

        while (loop) {
            System.out.println("\n[1] Manage Artists");
            System.out.println("[2] Manage Albums");
            System.out.println("[3] Manage Songs");
            System.out.println("[4] Manage Genres");

            System.out.println("[0] Exit");


            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> ArtistMenu.menu();
                case 2 -> AlbumMenu.menu();
                case 3 -> SongMenu.menu();
                case 4 -> GenreMenu.menu();
                default -> loop = false;
            }
        }

    }
}
