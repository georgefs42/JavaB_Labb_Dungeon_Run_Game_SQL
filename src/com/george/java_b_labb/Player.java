package com.george.java_b_labb;

import java.util.Random;
import java.util.Scanner;

public abstract class Player implements Combatant {
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int health;
    protected int experience;
    protected int level;
    protected int baseDamage;
    protected int gold;

    private MariaDBConnector dbConnector;

    // Constructor with initialization of player attributes
    public Player(String name, MariaDBConnector dbConnector) {
        this.name = name;
        this.strength = 10;
        this.intelligence = 5;
        this.agility = 5;
        this.health = 100;
        this.experience = 0;
        this.level = 1;
        this.baseDamage = 10;
        this.gold = 0;
        this.dbConnector = dbConnector;
    }

    // Player's action menu
    public void act() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.GREEN_BACKGROUND + "1. Attack" + Colors.RESET);
        System.out.println(Colors.WHITE_BACKGROUND + "2. Flee" + Colors.RESET);
        System.out.println(Colors.RED_BACKGROUND + "3. Status" + Colors.RESET + "\n");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> attack();
            case 2 -> flee();
            case 3 -> getStatus();
            default -> {}
        }
    }

    // Player attacks the target
    public void attack() {
        // Implement attack logic here...
    }

    // Player takes damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
        }
    }

    // Player attempts to flee from battle
    public void flee() {
        Random rand = new Random();
        int chanceToEscape = agility * 5;
        if (rand.nextInt(100) < chanceToEscape) {
            System.out.println(name + " successfully flees from the battle.");
        } else {
            System.out.println(name + " failed to flee.");
            attack(null);
        }
    }

    // Display player's status
    public void getStatus() {
        String playerStatus = getPlayerStatusAsString();
        System.out.println(Colors.PURPLE_BACKGROUND + "=================================");
        System.out.println(playerStatus);
        System.out.println("=================================\n" + Colors.RESET);

        writeStatusToDatabase(playerStatus);
    }

    // Gain experience points
    public void gainExperience(int amount) {
        experience += amount;
        levelUp(); // Check for level up after gaining experience
    }

    // Level up the player if enough experience is gained
    void levelUp () {
        if (experience >= 100) {
            level++;
            experience -= 100;
            System.out.println(name + " leveled up to level " + level + "!");
        }
    }

    // Calculate damage dealt by the player
    public int calculateDamage() {
        return baseDamage + (strength * 2 / 4 + 1);
    }

    // Write player status to the database
    private void writeStatusToDatabase(String status) {
        dbConnector.open();
        dbConnector.writeToPlayer(name, strength, intelligence, agility, health, experience, level, baseDamage, gold);
    }

    // Convert player status to a formatted string
    private String getPlayerStatusAsString() {
        StringBuilder status = new StringBuilder();
        status.append("Player Name: ").append(name).append("\n");
        status.append("Level: ").append(level).append("\n");
        status.append("Strength: ").append(strength).append("\n");
        status.append("Intelligence: ").append(intelligence).append("\n");
        status.append("Agility: ").append(agility).append("\n");
        status.append("Health: ").append(health).append("\n");
        status.append("Experience: ").append(experience).append("\n");
        status.append("Gold: ").append(gold).append("\n");
        // Add other player status information...

        return status.toString();
    }
}