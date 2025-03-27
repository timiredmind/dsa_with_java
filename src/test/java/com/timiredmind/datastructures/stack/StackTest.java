package com.timiredmind.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void testParameterizedConstructor() {
        Stack<Integer> stack = new Stack<>(1);

        assertEquals(stack.getTop().value, 1);
        assertNull(stack.getTop().next);
        assertEquals(stack.getLength(), 1);
    }

    @Test
    public void testDefaultConstructor() {
        Stack<Integer> stack = new Stack<>();

        assertNull(stack.getTop());
        assertEquals(stack.getLength(), 0);
    }

    @Test
    public void testPushMethodForEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        assertEquals(stack.getLength(), 1);
        assertEquals(stack.getTop().value, 3);
    }

    @Test
    public void testPushMethodForStackWithNode() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);

        assertEquals(stack.getTop().value, 2);
        assertEquals(stack.getTop().next.value, 1);
        assertEquals(stack.getLength(), 2);
    }

    @Test
    public void testPopMethodForEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        assertNull(stack.pop());
        assertNull(stack.getTop());
        assertEquals(stack.getLength(), 0);
    }

    @Test
    public void testPopMethodForSingleNodeStack() {
        Stack<Integer> stack = new Stack<>(1);
        assertEquals(stack.pop().value, 1);

        assertNull(stack.getTop());
        assertEquals(stack.getLength(), 0);
    }

    @Test
    public void testPopMethodForMultipleNodeStack() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);
        stack.push(3);


        assertEquals(stack.getLength(), 3);

        assertEquals(stack.pop().value, 3);
        assertEquals(stack.getTop().value, 2);
        assertEquals(stack.getTop().next.value, 1);
        assertEquals(stack.getLength(), 2);
    }
}
