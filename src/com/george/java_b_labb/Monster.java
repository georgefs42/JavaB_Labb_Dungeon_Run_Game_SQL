// Monster class
package com.george.java_b_labb;

public class Monster implements Combatant {
    public String name;
    public int health;
    public int strength;

    // Constructor to initialize the monster
    public Monster(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    // Monster attacks the target (Combatant)
    @Override
    public void attack(Combatant target) {
        int damage = calculateDamage();
        System.out.println(name + " attacks for " + damage + " damage.");
        if (target != null) {
            target.takeDamage(damage);
        }
    }

    // Monster takes damage
    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
            // Additional logic for handling monster defeat can be added here
        } else {
            System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
        }
    }

    // Calculate damage dealt by the monster
    @Override
    public int calculateDamage() {
        return strength;
    }

    public void attack() {
    }
}