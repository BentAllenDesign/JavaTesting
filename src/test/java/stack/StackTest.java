package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    //isEmpty
    @Test
    public void isEmpty_shouldReturnTrue_ifStackIsEmpty() {
        boolean isEmpty = stack.isEmpty();
        assertTrue(isEmpty);
    }

    @Test
    public void isEmpty_shouldReturnFalse_ifStackIsNotEmpty() {
        stack.push(1);
        boolean isEmpty = stack.isEmpty();
        assertFalse(isEmpty);
    }

    //push
    @Test(expected = NullPointerException.class)
    public void push_shouldThrowException_ifNotGivenValidObject() {
        stack.push(null);
    }

    //pop
    @Test(expected = EmptyStackException.class)
    public void pop_shouldThrowEmptyStackException_ifStackIsEmpty() {
        stack.pop();
    }

    @Test
    public void pop_shouldReturnObject_ifStackIsNotEmpty() {
        String testObj = "Test";
        stack.push(testObj);
        Object returnObj = stack.pop();
        assertEquals(testObj, returnObj);
    }

    @Test
    public void isEmpty_shouldReturnTrue_ifPopIsCalledWithOneObjectInStack() {
        stack.push("test");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    //peek
    @Test(expected = EmptyStackException.class)
    public void peek_shouldThrowEmptyStackException_ifStackIsEmpty() {
        stack.peek();
    }

    @Test
    public void peek_shouldReturnObject_ifCalledWithOneObjectOnStack() {
        Integer testObj = 1;
        stack.push(testObj);
        Object returnObj = stack.peek();
        assertEquals(testObj, returnObj);
    }

    @Test
    public void pop_shouldReturnSecondObject_peek_shouldReturnFirstObject_ifCalledAfterPopWithTwoObjectsOnStack() {
        Integer first = 1;
        Integer second = 2;
        stack.push(first);
        stack.push(second);
        Object popReturn = stack.pop();
        Object peekReturn = stack.peek();
        assertEquals(second, popReturn);
        assertEquals(first, peekReturn);
    }

    //contains
    @Test
    public void contains_shouldReturnFalse_ifGivenObjectNotInStack() {
        stack.push(0);
        boolean contains = stack.contains(1);
        assertFalse(contains);
    }

    @Test
    public void contains_shouldReturnTrue_ifGivenFirstObjectInStack() {
        stack.push(1);
        boolean contains = stack.contains(1);
        assertTrue(contains);
    }

    @Test
    public void contains_shouldReturnTrue_ifGivenFourthObjectInStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        boolean contains = stack.contains(4);
        assertTrue(contains);
    }

    //size
    @Test
    public void size_shouldReturnInteger_representingNumberOfNodesInStructure() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int test = 4;
        int returnedSize = stack.size();
        assertEquals(test, returnedSize);
    }
}