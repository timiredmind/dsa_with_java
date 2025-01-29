package com.timiredmind.datastructures.linkedlist;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testRemoveFirstMethodWithSingleNode() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(20);
        SinglyLinkedList.Node<Integer> firstNode = singlyLinkedList.removeFirst();

        assertNull(singlyLinkedList.getHead());
        assertNull(singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getLength(), 0);
        assertEquals(firstNode.value, 20);
    }

    @Test
    public void testRemoveFirstMethodFromMultipleNodes() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(0);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);

        SinglyLinkedList.Node<Integer> firstNode = singlyLinkedList.removeFirst();

        assertNotNull(singlyLinkedList.getHead());
        assertNotNull(singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getHead().value, 1);
        assertEquals(singlyLinkedList.getTail().value, 2);
        assertEquals(singlyLinkedList.getLength(), 2);
        assertEquals(firstNode.value, 0);
    }

    @Test
    public void testRemoveFirstMethodOnEmptyList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertNull(singlyLinkedList.removeFirst());
    }


    @Test
    public void testGetMethodForNegativeInteger() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        assertNull(singlyLinkedList.get(-1));
    }

    @Test
    public void testGetMethodWhenIndexIsOutOfBound() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        assertNull(singlyLinkedList.get(5));
    }

    @Test
    public void testGetMethodForEmptyLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertNull(singlyLinkedList.get(0));
    }

    @Test
    public void testGetMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(0);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        assertNotNull(singlyLinkedList.get(0));
        assertEquals(singlyLinkedList.get(0).value, 0);

        assertNotNull(singlyLinkedList.get(1));
        assertEquals(singlyLinkedList.get(1).value, 1);

        assertNotNull(singlyLinkedList.get(2));
        assertEquals(singlyLinkedList.get(2).value, 2);
    }


    @Test
    public void testSetMethodWhenValueIsNull() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(2);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            singlyLinkedList.set(0, null);
        });

        assertNotNull(exception);
        assertEquals(exception.getMessage(), "Value of Node be null");
    }

    @Test
    public void testSetMethodForNegativeIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        assertFalse(singlyLinkedList.set(-1, 2));
    }

    @Test
    public void testSetMethodForOutOfBoundIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        assertFalse(singlyLinkedList.set(3, 4));
    }


    @Test
    public void testSetMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        singlyLinkedList.append(2);
        assertTrue(singlyLinkedList.set(0, 10));
        assertTrue(singlyLinkedList.set(1, 20));

        assertEquals(singlyLinkedList.getHead().value, 10);
        assertEquals(singlyLinkedList.getTail().value, 20);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testSetMethodForEmptyLinkedList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertFalse(singlyLinkedList.set(0, 3));
    }

    @Test
    public void testInsertMethodForNegativeIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        assertFalse(singlyLinkedList.insert(-2, 0));
    }

    @Test
    public void testInsertMethodForOutOfRangeMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(2);
        assertFalse(singlyLinkedList.insert(5, 5));
    }

    @Test
    public void testInsertMethodForWhenValueIsNull() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(0);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        Exception exception = assertThrows(NullPointerException.class, () ->
                singlyLinkedList.insert(1, null));

        assertNotNull(exception);
        assertEquals(exception.getMessage(), "Value of Node be null");
    }

    @Test
    public void testInsertMethodWhenIndexIsZero() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(0);

        assertTrue(singlyLinkedList.insert(0, 2));
        assertEquals(singlyLinkedList.getHead().value, 2);
        assertEquals(singlyLinkedList.getTail().value, 0);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testInsertMethodWhenIndexIsLast() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(10);
        singlyLinkedList.append(20);
        singlyLinkedList.append(30);
        singlyLinkedList.append(40);

        singlyLinkedList.insert(4, 50);

        assertEquals(singlyLinkedList.getHead().value, 10);
        assertEquals(singlyLinkedList.getTail().value, 50);
        assertEquals(singlyLinkedList.getLength(), 5);
    }

    @Test
    public void testRemoveMethodForNegativeIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(20);
        assertNull(singlyLinkedList.remove(-1));
    }

    @Test
    public void testRemoveMethodForOutOfBoundInteger() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(20);
        assertNull(singlyLinkedList.remove(1));
    }

    @Test
    public void testRemoveMethod() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(10);
        singlyLinkedList.append(20);
        singlyLinkedList.append(30);
        singlyLinkedList.append(40);

        SinglyLinkedList.Node<Integer> node = singlyLinkedList.remove(2);
        assertNotNull(node);
        assertEquals(node.value, 30);
        assertNull(node.next);
        assertEquals(singlyLinkedList.getLength(), 3);
    }

    @Test
    public void testRemoveMethodWhenIndexIsZero() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(10);
        singlyLinkedList.append(20);
        singlyLinkedList.append(30);

        SinglyLinkedList.Node<Integer> node = singlyLinkedList.remove(0);

        assertNotNull(node);
        assertNull(node.next);
        assertEquals(node.value, 10);

        assertEquals(singlyLinkedList.getHead().value, 20);
        assertEquals(singlyLinkedList.getTail().value, 30);
        assertEquals(singlyLinkedList.getLength(), 2);
    }

    @Test
    public void testRemoveMethodWhenIndexIsLastIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(10);
        singlyLinkedList.append(20);

        SinglyLinkedList.Node<Integer> node = singlyLinkedList.remove(1);
        assertNotNull(node);
        assertNull(node.next);
        assertEquals(node.value, 20);
        assertEquals(singlyLinkedList.getHead(), singlyLinkedList.getTail());
        assertEquals(singlyLinkedList.getLength(), 1);
    }

}
