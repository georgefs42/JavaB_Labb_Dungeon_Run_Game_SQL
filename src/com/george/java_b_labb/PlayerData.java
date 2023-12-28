package com.george.java_b_labb;

public class PlayerData {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int experience;
    private int level;
    private int baseDamage;
    private int gold;

    public PlayerData(String name, int strength, int intelligence, int agility, int health, int experience, int level, int baseDamage, int gold) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
        this.gold = gold;
    }

    // Add getters for the fields...

    public String getName () {
        return name;
    }

    public int getStrength () {
        return strength;
    }

    public int getIntelligence () {
        return intelligence;
    }

    public int getAgility () {
        return agility;
    }

    public int getHealth () {
        return health;
    }

    public int getExperience () {
        return experience;
    }

    public int getLevel () {
        return level;
    }

    public int getBaseDamage () {
        return baseDamage;
    }

    public int getGold () {
        return gold;
    }
}
