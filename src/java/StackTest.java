import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    private Stack<Integer> stackVector;
    private Stack<Integer> stackArrayList;

    @BeforeEach
    void setUp() {
        stackVector = new StackVector<>();
        stackArrayList = new StackArrayList<>();
    }

    @Test
    void testPushAndSize() {
        // post: the value is added to the stack
        stackVector.push(10);
        stackVector.push(20);
        stackArrayList.push(10);
        stackArrayList.push(20);

        assertEquals(2, stackVector.size());
        assertEquals(2, stackArrayList.size());
    }

    @Test
    void testPop() {
        // pre: stack is not empty
        // post: most recently pushed item is removed and returned
        stackVector.push(10);
        stackVector.push(20);
        stackArrayList.push(10);
        stackArrayList.push(20);

        assertEquals(20, stackVector.pop());
        assertEquals(20, stackArrayList.pop());
        assertEquals(10, stackVector.pop());
        assertEquals(10, stackArrayList.pop());

        assertTrue(stackVector.empty());
        assertTrue(stackArrayList.empty());
    }

    @Test
    void testPeek() {
        // pre: stack is not empty
        // post: top value (next to be popped) is returned
        stackVector.push(10);
        stackVector.push(20);
        stackArrayList.push(10);
        stackArrayList.push(20);

        assertEquals(20, stackVector.peek());
        assertEquals(20, stackArrayList.peek());

        // La pila sigue con el mismo tamaño después de peek()
        assertEquals(2, stackVector.size());
        assertEquals(2, stackArrayList.size());
    }

    @Test
    void testEmpty() {
        // post: returns true if and only if the stack is empty
        assertTrue(stackVector.empty());
        assertTrue(stackArrayList.empty());

        stackVector.push(10);
        stackArrayList.push(10);

        assertFalse(stackVector.empty());
        assertFalse(stackArrayList.empty());
    }

    @Test
    void testPopOnEmptyStack() {
        // pre: stack is not empty
        assertThrows(RuntimeException.class, () -> stackVector.pop());
        assertThrows(RuntimeException.class, () -> stackArrayList.pop());
    }

    @Test
    void testPeekOnEmptyStack() {
        assertThrows(RuntimeException.class, () -> stackVector.peek());
        assertThrows(RuntimeException.class, () -> stackArrayList.peek());
    }
}
