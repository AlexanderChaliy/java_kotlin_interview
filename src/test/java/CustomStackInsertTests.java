import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackInsertTests {
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
    public void testInsertAtBeginning() {
        stack.insert(0, 10);
        assertEquals(10, stack.pop());
    }

    @Test
    public void testInsertAtEnd() {
        stack.push(10);
        stack.push(20);
        stack.insert(2, 30);
        assertEquals(3, stack.size());
        assertStackElements(stack, new int[]{30, 20, 10});
    }

    @Test
    public void testInsertInMiddle() {
        stack.push(10);
        stack.push(30);
        stack.insert(1, 20);
        assertEquals(3, stack.size());
        assertStackElements(stack, new int[]{30, 20, 10});
    }

    @Test
    public void testInsertInvalidPosition() {
        assertThrows(NoSuchElementException.class, () -> {
            stack.insert(-1, 10);
        });
        assertThrows(NoSuchElementException.class, () -> {
            stack.insert(1, 10);
        });
    }

    @Test
    public void testGetMaxAfterInsertNewMax() {
        stack.push(10);
        stack.push(20);
        stack.insert(2, 30);
        assertEquals(30, stack.getMax());
    }

    @Test
    public void testGetMaxAfterInsertNotMax() {
        stack.push(10);
        stack.push(30);
        stack.insert(1, 20);
        assertEquals(30, stack.getMax());
    }

    @Test
    public void testGetMaxAfterInsertEqualMax() {
        stack.push(10);
        stack.push(30);
        stack.insert(1, 30);
        assertEquals(30, stack.getMax());
    }

    private void assertStackElements(CustomStack stack, int[] expectedElements) {
        CustomStack tempStack = new CustomStack();
        for (int element : expectedElements) {
            tempStack.push(element);
        }

        for (int element : expectedElements) {
            assertEquals(element, stack.pop());
        }
    }
}
