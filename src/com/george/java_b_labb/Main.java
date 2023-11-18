// Main class
package com.george.java_b_labb;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Welcome message and game information
        System.out.println(Colors.BLUE_BOLD + "========================================");
        System.out.println(" Hello and welcome to my Java_B project");
        System.out.println("         'Dungeon Run' GAME!");
        System.out.println("   (C) GEORGE YOUSSEF - STI 2023");
        System.out.println("========================================" + Colors.RESET);

        // Player's name input
        System.out.print(Colors.YELLOW_BOLD + "Enter your name: " + Colors.RESET);
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        // Greeting message
        System.out.println(Colors.PURPLE_BOLD + "\nHello " + playerName + "! \nPlease choose a number to start the game: \n" + Colors.RESET);

        while (true) {
            // Invoke the act method to get the player's action
            player.act();

            // Main menu options
            System.out.println(Colors.RED_BACKGROUND + "1. Fight a monster" + Colors.RESET);
            System.out.println(Colors.WHITE_BACKGROUND + "2. Status" + Colors.RESET);
            System.out.println(Colors.BLACK_BACKGROUND + "3. Quit\n" + Colors.RESET);
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Create a Goblin monster and initiate the combat
                Combatant monster = new Monster("Goblin", 50, 8);
                player.attack(monster);
                monster.attack(player);
            } else if (choice == 2) {
                // Display player's status
                player.getStatus();
            } else if (choice == 3) {
                // Exit the game
                System.out.println(Colors.GREEN_BACKGROUND + "========================== \n   Thanks for playing! \n==========================");
                break;
            }

            // Gain experience and level up the player
            player.gainExperience(20);
            player.levelUp();
        }
    }
}