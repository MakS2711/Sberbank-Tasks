package dorofeev;


import dorofeev.exception.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestStack {
    Stack stack;

    @BeforeEach
    public void createNewStack() {
        stack = new Stack();
    }

    @Test
    public void push_mustInsertElement() throws EmptyStackException {
        stack.push("First");

        Assertions.assertEquals("First", stack.top());
    }

    @Test
    public void pop_mustReturnElement() throws EmptyStackException {
        stack.push("First");
        stack.push(2);

        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals("First", stack.top());
    }

    @Test
    public void pop_mustThrowEmptyStackException() {
        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void top_mustReturnFirstElementWithoutDeletingIt() throws EmptyStackException {
        stack.push("First");
        stack.push(2);

        Assertions.assertEquals(2, stack.top());
    }

    @Test
    public void top_mustThrowEmptyStackException() {
        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.top();
        });
    }

    @Test
    public void isEmpty_mustReturnTrue() {
        Assertions.assertTrue(stack.isEmpty());
    }

}
