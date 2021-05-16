package com.tobiasekman.ui;

import com.tobiasekman.ui.managers.ArtistManager;

public class ArtistMenu {

    public static void menu() {

        ArtistManager am = new ArtistManager();

        boolean loop = true;
        System.out.println("-Manage Artists-");

        while (loop) {
            System.out.println("\n[1] Show all artists");
            System.out.println("[2] Create artist");
            System.out.println("[3] Update artist");
            System.out.println("[4] Delete artist");
            System.out.println("[5] Show artist");
            System.out.println("[6] Update artist bio");

            System.out.println("[0] Back");


            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> am.showAllArtists();
                case 2 -> am.createArtist();
                case 3 -> am.updateArtist();
                case 4 -> am.deleteArtist();
                case 5 -> am.showArtist();
                case 6 -> am.updateArtistBio();
                default -> loop = false;
            }
        }

    }
}
