import com.george.java_b_labb.Player;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        //Create a new Player object before each test method
        player = new Player("TestPlayer");
    }

    @Test
    void testPlayerInitialization() {
        // Test if the Player object is initialized with the correct values
        assertEquals("TestPlayer", player.name);
        assertEquals(10, player.strength);
        assertEquals(5, player.intelligence);
        assertEquals(5, player.agility);
        assertEquals(100, player.health);
        assertEquals(0, player.experience);
        assertEquals(1, player.level);
        assertEquals(10, player.baseDamage);
        assertEquals(0, player.gold);
    }

    @Test
    void testCalculateDamage() {
        // Test the calculation of damage based on the player's attributes
        assertEquals(16, player.calculateDamage()); // 10 (base damage) + (10 * 2 / 4 + 1) = 12
    }

    @Test
    void testGainExperience() {
        // Test if the player can gain experience points
        player.gainExperience(50);
        assertEquals(50, player.experience);
    }

    @Test
    void testLevelUp() {
        // Test if the player can level up when they have enough experience
        player.gainExperience(150); // Should be enough to level up
        player.levelUp();
        assertEquals(2, player.level);
        assertEquals(50, player.experience);
    }

    @Test
    void testLevelUpNotEnoughExperience() {
        // Test if the player doesn't level up when they don't have enough experience
        player.gainExperience(99); // Not enough to level up
        player.levelUp();
        assertEquals(1, player.level);
        assertEquals(99, player.experience);
    }

    @AfterAll
    public static void tearDown() {
        // Add a final message after the unit test as a report
        System.out.println("Player Test Report:");
        System.out.println("All player tests completed successfully!");
    }
}
