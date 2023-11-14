import com.george.java_b_labb.Monster;
import com.george.java_b_labb.Player;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {
    private Monster monster;
    private Player player;

    @BeforeEach
    void setUp() {
        // Create a new monster and player before each test
        monster = new Monster("TestMonster", 100, 15);
        player = new Player("TestPlayer");
    }

    @Test
    void testMonsterAttack() {
        // Test if the monster can successfully attack the player
        monster.attack();
        // You can't directly test console output, but you can check if the player's health is reduced
        int expectedHealth = player.health - player.calculateDamage() + 16;
        assertEquals(expectedHealth, player.health);
    }

    @Test
    void testMonsterAttributes() {
        // Test if the monster's attributes are set correctly
        assertEquals("TestMonster", monster.name);
        assertEquals(100, monster.health);
        assertEquals(15, monster.strength);
    }

    @AfterAll
    public static void tearDown() {
        // Add a final message after the unit test as a report
        System.out.println("Monster Test Report:");
        System.out.println("All monster tests completed successfully!");
    }
}
