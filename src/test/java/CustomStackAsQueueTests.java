import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackAsQueueTests {
    private CustomStack stack;

    @BeforeEach
    public void setUp() {
        stack = new CustomStack();
    }

    @AfterEach
    public void tearDown() {
        stack = null;
    }

    @Test
    public void testAsQueueMultipleElements() {
        stack.push(5);
        stack.push(10);
        stack.push(15);

        int[] expected = {5, 10, 15};  // Queue order (FIFO)
        assertArrayEquals(expected, stack.asQueue());
    }

    @Test
    public void testAsQueueSingleElement() {
        stack.push(42);

        int[] expected = {42};
        assertArrayEquals(expected, stack.asQueue());
    }

    @Test
    public void testAsQueueEmptyStack() {
        int[] expected = {};  // Expect empty array
        assertArrayEquals(expected, stack.asQueue());
    }

    @Test
    public void testAsQueueAfterPop() {
        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.pop();  // Remove the last element (9)

        int[] expected = {3, 6};  // Remaining elements in queue order
        assertArrayEquals(expected, stack.asQueue());
    }

    @Test
    public void testAsQueueAfterInsert() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.insert(1, 10);  // Insert 10 at position 1

        int[] expected = {1, 10, 2, 3};  // Order after insertion in queue format
        assertArrayEquals(expected, stack.asQueue());
    }
}
