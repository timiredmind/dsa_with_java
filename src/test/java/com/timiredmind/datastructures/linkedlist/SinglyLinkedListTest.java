package com.timiredmind.datastructures.linkedlist;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTest {

    @Test
    public void testParameterizedConstructor() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>("Node 1");
        SinglyLinkedList.Node<String> node1 = new SinglyLinkedList.Node<>("Node 1");
        assertNotNull(singlyLinkedList.getHead());
        assertNotNull(singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getHead().value, node1.value);
        assertEquals(singlyLinkedList.getTail().value, node1.value);
        assertEquals(singlyLinkedList.getHead(), singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getLength(), 1);
    }

    @Test
    public void testDefaultConstructor() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        assertNull(singlyLinkedList.getHead());
        assertNull(singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getLength(), 0);
    }

    @Test
    public void testNullValuePassedToParameterizedConstructor() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new SinglyLinkedList<>(null);
        });

        String expectedMessage = "Value of Node be null";
        assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    public void testLargeValueInConstructor() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, singlyLinkedList.getHead().value);
        assertNull(singlyLinkedList.getHead().next);
        assertEquals(Integer.MAX_VALUE, singlyLinkedList.getTail().value);
        assertNull(singlyLinkedList.getTail().next);
    }


    @Test
    public void testAppendLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        singlyLinkedList.append(2);

        assertNotNull(singlyLinkedList.getHead());
        assertNotNull(singlyLinkedList.getTail());

        assertEquals(singlyLinkedList.getHead().value, 1);
        assertEquals(singlyLinkedList.getHead().next, singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getTail().value, 2);
        assertNull(singlyLinkedList.getTail().next);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testAppendForEmptyLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.append(0);

        assertNotNull(singlyLinkedList.getHead());
        assertNotNull(singlyLinkedList.getTail());

        assertEquals(singlyLinkedList.getHead().value, 0);
        assertNull(singlyLinkedList.getHead().next);
        assertEquals(singlyLinkedList.getTail().value, 0);
        assertNull(singlyLinkedList.getTail().next);

        assertEquals(singlyLinkedList.getLength(), 1);
    }

    @Test
    public void testAppendWithNullValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            singlyLinkedList.append(null);
        });

        assertNotNull(exception);
        String expectedMessage = "Value of Node be null";
        assertEquals(exception.getMessage(), expectedMessage);
    }


    @Test
    public void testRemoveLastMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        SinglyLinkedList.Node<Integer> lastNode = singlyLinkedList.getTail();
        SinglyLinkedList.Node<Integer> nodeRemoved = singlyLinkedList.removeLast();
        SinglyLinkedList.Node<Integer> newTail = singlyLinkedList.getTail();


        assertEquals(lastNode, nodeRemoved);
        assertEquals(nodeRemoved.value , 3);
        assertNull(nodeRemoved.next);
        assertNotEquals(lastNode, newTail);
        assertEquals(newTail.value, 2);
        assertNull(newTail.next);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testRemoveLastMethodOnEmptyLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertNull(singlyLinkedList.removeLast());
        assertEquals(singlyLinkedList.getLength(), 0);
    }

    @Test
    public void testRemoveLastMethodOnLinkedLinkedWithANode() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        SinglyLinkedList.Node<Integer> nodeRemoved = singlyLinkedList.removeLast();

        assertNull(singlyLinkedList.getHead());
        assertNull(singlyLinkedList.getTail());
        assertEquals(nodeRemoved.value, 1);
        assertNull(nodeRemoved.next);
        assertEquals(singlyLinkedList.getLength(), 0);
    }

    @Test
    public void testPrependMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        SinglyLinkedList.Node<Integer> firstHead = singlyLinkedList.getHead();
        SinglyLinkedList.Node<Integer> firstTail = singlyLinkedList.getTail();

        singlyLinkedList.prepend(2);
        SinglyLinkedList.Node<Integer> newHead = singlyLinkedList.getHead();
        SinglyLinkedList.Node<Integer> newTail = singlyLinkedList.getTail();


        assertEquals(newHead.value,  2);
        assertNotEquals(newHead, firstHead);
        assertEquals(firstTail, newTail);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testPrependMethodOnEmptyLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.prepend(20);

        SinglyLinkedList.Node<Integer> head = singlyLinkedList.getHead();
        SinglyLinkedList.Node<Integer> tail = singlyLinkedList.getTail();
        assertEquals(head, tail);
        assertEquals(1, singlyLinkedList.getLength());
    }

    @Test
    public void testPrependMethodWhenValueIsNull() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            singlyLinkedList.prepend(null);
        });

        String expectedMessage = "Value of Node be null";
        assertNotNull(exception);
        assertEquals(exception.getMessage(), expectedMessage);
    }
}
