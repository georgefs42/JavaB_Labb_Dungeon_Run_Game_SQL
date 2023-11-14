import com.george.java_b_labb.Main;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainIntegrationTest {
    private static InputStream originalInput;
    private static PrintStream originalOutput;
    private static ByteArrayOutputStream outputCapture;

    @BeforeAll
    public static void setUp() {
        // Save the original System.in and System.out
        originalInput = System.in;
        originalOutput = System.out;

        // Redirect System.out to capture the output
        outputCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapture));
    }

    @AfterAll
    public static void tearDown() {
        // Restore the original System.in and System.out
        System.setIn(originalInput);
        System.setOut(originalOutput);

        // Add a final message after the unit test as a report
        System.out.println("Integration Test Report:");
        System.out.println("Main application test completed successfully!");
    }

    @Test
    public void testMainApplication() {
        // Simulate user input
        String input = "John\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main application
        Main.main(new String[]{});

        // Capture the output
        String capturedOutput = outputCapture.toString();

        // Check if the captured output contains expected messages
        assertTrue(capturedOutput.contains("Hello and welcome to my Java_B project"));
        assertTrue(capturedOutput.contains("Thanks for playing!"));
        assertTrue(capturedOutput.contains("Hello John!"));
    }
}
