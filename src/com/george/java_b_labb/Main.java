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
        Player player = new Player(playerName, dbConnector) {
            @Override
            public void attack(Combatant target) {

            }

            @Override
            public String getMonsterStatusAsString() {
                return null;
            }
        };

        while (true) {
            player.act();

            System.out.println(Colors.RED_BACKGROUND + "1. Fight a monster" + Colors.RESET);
            System.out.println(Colors.WHITE_BACKGROUND + "2. Status" + Colors.RESET);
            System.out.println(Colors.BLACK_BACKGROUND + "3. Display Player Data" + Colors.RESET);
            System.out.println(Colors.BLACK_BACKGROUND + "4. Quit\n" + Colors.RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    Combatant monster = new Monster("Goblin", 50, 8, dbConnector);
                    player.attack(monster);
                    monster.attack(player);
                    break;
                case 2:
                    player.getStatus();
                    break;
                case 3:
                    displayPlayerData();
                    break;
                case 4:
                    quitApplication(player);
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

            player.gainExperience(20);
            player.levelUp();
        }
    }

    private static void displayPlayerData() {
        System.out.print(Colors.YELLOW_BOLD + "Enter the player's name to display data: " + Colors.RESET);
        String playerName = scanner.nextLine();
/*this.name = name;


        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
        this.gold = gold;*/
        // Retrieve player data and display it
        PlayerData playerData = dbConnector.getPlayerData(playerName);
        if (playerData != null) {
            System.out.println("Player Data:");
            System.out.println("Name: " + playerData.getName());
            System.out.println("Strength: " + playerData.getStrength());
            System.out.println("Intelligence: " + playerData.getIntelligence());
            System.out.println("Agility: " + playerData.getAgility());
            System.out.println("Health: " + playerData.getHealth ());
            System.out.println("Experience: " + playerData.getExperience ());
            System.out.println("Level: " + playerData.getLevel ());
            System.out.println("BaseDamage: " + playerData.getBaseDamage ());
            System.out.println("Gold: " + playerData.getGold ());
        } else {
            System.out.println("Player not found in the database.");
        }
    }

    private static void quitApplication(Player player) {
        System.out.println(Colors.GREEN_BACKGROUND + "========================== \n   Thanks for playing! \n==========================");
        player.getStatus();
    }
}
