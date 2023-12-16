// Combatant interface
package com.george.java_b_labb;

public interface Combatant {
    // Method for an entity to attack another entity
    void attack(Combatant target);

    // Method to handle an entity taking damage
    void takeDamage(int damage);

    // Method to calculate the damage dealt by an entity
    int calculateDamage();

    String getMonsterStatusAsString ();
}