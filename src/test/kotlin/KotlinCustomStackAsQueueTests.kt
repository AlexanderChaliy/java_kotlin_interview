import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KotlinCustomStackAsQueueTests {
    private var stack: KotlinCustomStack? = null

    @BeforeEach
    fun setUp() {
        stack = KotlinCustomStack()
    }

    @AfterEach
    fun tearDown() {
        stack = null
    }

    @Test
    fun testAsQueueMultipleElements() {
        stack!!.push(5)
        stack!!.push(10)
        stack!!.push(15)

        val expected = intArrayOf(5, 10, 15) // Queue order (FIFO)
        Assertions.assertArrayEquals(expected, stack!!.asQueue())
    }

    @Test
    fun testAsQueueSingleElement() {
        stack!!.push(42)

        val expected = intArrayOf(42)
        Assertions.assertArrayEquals(expected, stack!!.asQueue())
    }

    @Test
    fun testAsQueueEmptyStack() {
        val expected = intArrayOf() // Expect empty array
        Assertions.assertArrayEquals(expected, stack!!.asQueue())
    }

    @Test
    fun testAsQueueAfterPop() {
        stack!!.push(3)
        stack!!.push(6)
        stack!!.push(9)
        stack!!.pop() // Remove the last element (9)

        val expected = intArrayOf(3, 6) // Remaining elements in queue order
        Assertions.assertArrayEquals(expected, stack!!.asQueue())
    }

    @Test
    fun testAsQueueAfterInsert() {
        stack!!.push(1)
        stack!!.push(2)
        stack!!.push(3)
        stack!!.insert(1, 10) // Insert 10 at position 1

        val expected = intArrayOf(1, 10, 2, 3) // Order after insertion in queue format
        Assertions.assertArrayEquals(expected, stack!!.asQueue())
    }
}