package com.tobiasekman.ui;

import com.tobiasekman.ui.managers.AlbumManager;

public class AlbumMenu {

    public static void menu() {

        AlbumManager am = new AlbumManager();

        boolean loop = true;
        System.out.println("-Manage Albums-");

        while (loop) {

            System.out.println("\n[1] Create album");
            System.out.println("[2] Show all albums");
            System.out.println("[3] Show album by name");
            System.out.println("[4] Show album by artist");
            System.out.println("[5] Delete album");

            System.out.println("[0] Back");


            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> am.createAlbum();
                case 2 -> am.showAllAlbums();
                case 3 -> am.showAlbumByName();
                case 4 -> am.showAlbumsByArtist();
                case 5 -> am.deleteAlbum();
                default -> loop = false;
            }
        }
    }
}
