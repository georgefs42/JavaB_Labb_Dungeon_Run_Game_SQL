package com.george.java_b_labb;
public class Monster {
    // Monster attributes
    public String name;
    public int health;
    public int strength;

    // Constructor to initialize the monster
    public Monster(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    // Monster attacks the player
    public void attack(com.george.java_b_labb.Player player) {
        int damage = player.calculateDamage();
        System.out.println(name + " attacks for " + damage + " damage.");
    }

    public void attack() {
    }
}
