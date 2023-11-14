package com.george.java_b_labb;

import java.util.Random;
import java.util.Scanner;

public class Player {
    public String name;
    public int strength;
    public int intelligence;
    public int agility;
    public int health;
    public int experience;
    public int level;
    public int baseDamage;
    public int gold;

    // Constructor to initialize the player
    public Player(String name) {
        this.name = name;
        this.strength = 10;
        this.intelligence = 5;
        this.agility = 5;
        this.health = 100;
        this.experience = 0;
        this.level = 1;
        this.baseDamage = 10;
        this.gold = 0;
    }

    // Player's actions menu
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

    // Player attacks
    public void attack() {
        int damage = calculateDamage();
        System.out.println(name + " attacks for " + damage + " damage.");
    }

    // Player attempts to flee from battle
    public void flee() {
        Random rand = new Random();
        int chanceToEscape = agility * 5;
        if (rand.nextInt(100) < chanceToEscape) {
            System.out.println(name + " successfully flees from the battle.");
        } else {
            System.out.println(name + " failed to flee.");
            attack();
        }
    }

    // Display player's status
    public void getStatus() {
        System.out.println(Colors.PURPLE_BACKGROUND + "=================================");
        System.out.println("Player Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Agility: " + agility);
        System.out.println("Health: " + health);
        System.out.println("Experience: " + experience);
        System.out.println("Gold: " + gold);
        System.out.println("=================================\n" + Colors.RESET);
    }

    // Gain experience points
    public void gainExperience(int amount) {
        experience += amount;
    }

    // Level up the player if enough experience is gained
    public void levelUp() {
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
}