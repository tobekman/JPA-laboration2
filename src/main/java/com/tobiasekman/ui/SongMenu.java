package com.tobiasekman.ui;

import com.tobiasekman.ui.managers.SongManager;

public class SongMenu {

    public static void menu() {

        SongManager sm = new SongManager();

        boolean loop = true;
        System.out.println("-Manage Genre-");

        while (loop) {
            System.out.println("\n[1] Add a song");
            System.out.println("[2] Show all songs");
            System.out.println("[3] Show songs by artist");
            System.out.println("[4] Delete song");

            System.out.println("[0] Back");

            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> sm.createSong();
                case 2 -> sm.showAllSongs();
                case 3 -> sm.showSongsByArtist();
                case 4 -> sm.deleteSong();

                default -> loop = false;
            }
        }
    }
}
