package com.tobiasekman.ui;

import com.tobiasekman.ui.managers.StatisticManager;

public class StatisticsMenu {

    public static void menu() {

        StatisticManager sm = new StatisticManager();

        boolean loop = true;
        System.out.println("-Manage Statistics-");

        while (loop) {
            System.out.println("\n[1] Artist statistics");
            System.out.println("[2] Genre statistics");

            System.out.println("[0] Back");

            int choice = MyScanner.intScanner();

            switch (choice) {
                case 1 -> sm.artistStats();
                case 2 -> sm.genreStats();

                default -> loop = false;
            }
        }
    }
}
