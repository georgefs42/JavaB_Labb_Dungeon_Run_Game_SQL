package com.george.java_b_labb;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MariaDBConnector dbConnector = new MariaDBConnector();

    public static void main(String[] args) {
        System.out.println(Colors.BLUE_BOLD + "========================================");
        System.out.println(" Hello and welcome to my Java_B project");
        System.out.println("         'Dungeon Run' GAME!");
        System.out.println("   (C) GEORGE YOUSSEF - STI 2023");
        System.out.println("========================================" + Colors.RESET);

        System.out.print(Colors.YELLOW_BOLD + "Enter your name: " + Colors.RESET);
        String playerName = scanner.nextLine();
        Player player = new Player(playerName, dbConnector);

        OutputFile outputFile = new OutputFile("OutputFile.txt", dbConnector);

        while (true) {
            player.act();

            System.out.println(Colors.RED_BACKGROUND + "1. Fight a monster" + Colors.RESET);
            System.out.println(Colors.WHITE_BACKGROUND + "2. Status" + Colors.RESET);
            System.out.println(Colors.BLACK_BACKGROUND + "3. Quit\n" + Colors.RESET);
            int choice = scanner.nextInt();

            if (choice == 1) {
                Combatant monster = new Monster("Goblin", 50, 8, dbConnector);
                player.attack(monster);
                monster.attack(player);
            } else if (choice == 2) {
                player.getStatus();
            } else if (choice == 3) {
                System.out.println(Colors.GREEN_BACKGROUND + "========================== \n   Thanks for playing! \n==========================");
                player.getStatus();
                break;
            }

            player.gainExperience(20);
            player.levelUp();
        }
    }
}
