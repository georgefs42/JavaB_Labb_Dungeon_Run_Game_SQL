package com.george.java_b_labb;

public class Monster implements Combatant {
    public String name;
    public int health;
    public int strength;

    private MariaDBConnector dbConnector;

    // Constructor with initialization of monster attributes
    public Monster(String name, int health, int strength, MariaDBConnector dbConnector) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dbConnector = dbConnector;
    }

    // Monster attacks the target
    public void attack(Combatant target) {
        int damage = calculateDamage();
        System.out.println(name + " attacks for " + damage + " damage.");
        if (target != null) {
            target.takeDamage(damage);
        }
    }

    // Monster takes damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
        }
    }

    // Calculate damage dealt by the monster
    public int calculateDamage() {
        return strength;
    }

    @Override
    public String getMonsterStatusAsString () {
        return null;
    }
}