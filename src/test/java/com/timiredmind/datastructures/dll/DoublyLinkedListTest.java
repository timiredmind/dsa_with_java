package com.timiredmind.datastructures.dll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void testDefaultConstructor() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        assertNull(integerList.getHead());
        assertNull(integerList.getTail());
        assertEquals(integerList.getLength(), 0);
    }

    @Test
    public void testParameterizedConstructor() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        assertEquals(integerList.getHead().value, 1);
        assertNull(integerList.getHead().prev);
        assertNull(integerList.getHead().next);

        assertEquals(integerList.getTail().value, 1);
        assertNull(integerList.getTail().prev);
        assertNull(integerList.getTail().next);
        assertEquals(integerList.getLength(), 1);
    }

    @Test
    public void testAppendMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        integerList.append(1);

        assertEquals(integerList.getLength(), 1);
        assertEquals(integerList.getHead().value, 1);
        assertNull(integerList.getHead().next);
        assertNull(integerList.getHead().prev);

        assertEquals(integerList.getTail().value, 1);
        assertNull(integerList.getTail().next);
        assertNull(integerList.getTail().prev);
    }


    @Test
    public void testAppendMethodForListWithElement() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);

        assertEquals(integerList.getLength(), 2);

        assertEquals(integerList.getHead().value, 1);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 2);

        assertEquals(integerList.getTail().value, 2);
        assertNull(integerList.getTail().next);
        assertEquals(integerList.getTail().prev.value, 1);
    }

    @Test
    public void testRemoveLastMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        Node<Integer> node = integerList.removeLast();
        assertNull(node);
    }

    @Test
    public void testRemoveLastMethodForListWithOneElement() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        Node<Integer> node = integerList.removeLast();

        assertEquals(integerList.getLength(), 0);
        assertNull(integerList.getHead());
        assertNull(integerList.getTail());

        assertEquals(node.value, 1);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveLastMethodForListWithMultipleElement() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);

        assertEquals(integerList.getLength(), 3);

        Node<Integer> node = integerList.removeLast();
        assertEquals(node.value, 3);


        assertEquals(integerList.getLength(), 2);
        assertEquals(integerList.getHead().value, 1);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 2);

        assertEquals(integerList.getTail().value, 2);
        assertNull(integerList.getTail().next);
        assertEquals(integerList.getTail().prev.value, 1);
    }

    @Test
    public void testPrependMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        integerList.prepend(1);

        assertEquals(integerList.getLength(), 1);
        assertEquals(integerList.getHead().value, 1);
        assertNull(integerList.getHead().prev);
        assertNull(integerList.getHead().next);

        assertEquals(integerList.getTail().value, 1);
        assertNull(integerList.getTail().prev);
        assertNull(integerList.getTail().next);
    }

    @Test
    public void testPrependMethodForListWithOneElement() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.prepend(0);

        assertEquals(integerList.getLength(), 2);

        assertEquals(integerList.getHead().value, 0);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 1);

        assertEquals(integerList.getTail().value, 1);
        assertEquals(integerList.getTail().prev.value, 0);
        assertNull(integerList.getTail().next);
    }

    @Test
    public void testPrependMethodForListWithMultipleElements() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);
        integerList.append(4);

        assertEquals(integerList.getLength(), 4);

        integerList.prepend(0);
        assertEquals(integerList.getLength(), 5);

        assertEquals(integerList.getHead().value, 0);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 1);

        assertEquals(integerList.getTail().value, 4);
        assertNull(integerList.getTail().next);
        assertEquals(integerList.getTail().prev.value, 3);
    }

    @Test
    public void testRemoveFirstMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        Node<Integer> node = integerList.removeFirst();

        assertNull(node);
        assertNull(integerList.getHead());
        assertNull(integerList.getTail());
        assertEquals(integerList.getLength(), 0);
    }

    @Test
    public void testRemoveFirstMethodForSingleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        Node<Integer> node = integerList.removeFirst();

        assertEquals(node.value, 1);

        assertEquals(integerList.getLength(), 0);
        assertNull(integerList.getTail());
        assertNull(integerList.getHead());
    }

    @Test
    public void testRemoveFirstMethodForDoubleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        Node<Integer> node = integerList.removeFirst();

        assertEquals(node.value, 1);

        assertEquals(integerList.getLength(), 1);

        assertEquals(integerList.getTail().value, 2);
        assertNull(integerList.getTail().prev);
        assertNull(integerList.getTail().next);

        assertEquals(integerList.getHead().value, 2);
        assertNull(integerList.getHead().prev);
        assertNull(integerList.getHead().next);
    }

    @Test
    public void testRemoveFirstMethodForMultipleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);
        integerList.append(4);

        assertEquals(integerList.getLength(), 4);

        Node<Integer> nodeRemoved = integerList.removeFirst();

        assertEquals(nodeRemoved.value, 1);

        assertEquals(integerList.getLength(), 3);

        assertEquals(integerList.getHead().value, 2);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 3);

        assertEquals(integerList.getTail().value, 4);
        assertEquals(integerList.getTail().prev.value, 3);
        assertNull(integerList.getTail().next);
    }

    @Test
    public void testGetMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        assertNull(integerList.get(0));
    }

    @Test
    public void testGetMethodForSingleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);

        Node<Integer> nodeReturned = integerList.get(0);
        assertEquals(nodeReturned.value, 1);
        assertNull(integerList.get(2));
        assertNull(integerList.get(-1));
    }

    @Test
    public void testGetMethodForMultipleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);

        Node<Integer> firstNode = integerList.get(0);
        assertEquals(firstNode.value, 1);
        assertNull(firstNode.prev);
        assertEquals(firstNode.next.value, 2);

        Node<Integer> secondNode = integerList.get(1);

        assertEquals(secondNode.value, 2);
        assertEquals(secondNode.prev.value, 1);
        assertEquals(secondNode.next.value, 3);

        Node<Integer> thirdNode = integerList.get(2);
        assertEquals(thirdNode.value, 3);
        assertEquals(thirdNode.prev.value, 2);
        assertNull(thirdNode.next);
    }

    @Test
    public void testSetMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        assertFalse(integerList.set(0, 23));
        assertFalse(integerList.set(-1, 25));
    }


    @Test
    public void testSetMethodForSingleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);

        assertEquals(integerList.get(0).value, 1);
        assertTrue(integerList.set(0, 23));
        assertEquals(integerList.get(0).value, 23);

        assertFalse(integerList.set(1, 4));
    }

    @Test
    public void testSetMethodForMultipleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);
        integerList.append(4);
        integerList.append(5);

        assertTrue(integerList.set(0, 10));
        Node<Integer> node = integerList.get(0);
        assertEquals(node.value, 10);
        assertNull(node.prev);
        assertEquals(node.next.value, 2);

        assertTrue(integerList.set(1, 20));
        node = integerList.get(1);

        assertEquals(node.value, 20);
        assertEquals(node.prev.value, 10);
        assertEquals(node.next.value, 3);

        assertFalse(integerList.set(-1, 0));
        assertFalse(integerList.set(5, 0));
        assertEquals(integerList.getHead().value, 10);
    }

    @Test
    public void testInsertMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        assertFalse(integerList.insert(-1, 10));
        assertFalse(integerList.insert(2, 10));

        assertTrue(integerList.insert(0, 10));

        assertEquals(integerList.getHead().value, 10);
        assertEquals(integerList.getTail().value, 10);
        assertEquals(integerList.getLength(), 1);
    }

    @Test
    public void testInsertMethodForSingleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);

        assertEquals(integerList.getLength(), 1);

        assertTrue(integerList.insert(0, 10));
        assertEquals(integerList.getHead().value, 10);
        assertNull(integerList.getHead().prev);
        assertEquals(integerList.getHead().next.value, 1);

        assertEquals(integerList.getTail().value, 1);
        assertEquals(integerList.getTail().prev.value, 10);
        assertNull(integerList.getTail().next);
    }

    @Test
    public void testInsertMethodForMultipleElementListIntoIndexZero() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);

        assertEquals(integerList.getLength(), 3);
        assertEquals(integerList.getHead().value, 1);
        assertEquals(integerList.getTail().value, 3);

        assertTrue(integerList.insert(0, 0));

        assertEquals(integerList.getLength(), 4);
        assertEquals(integerList.getHead().value, 0);
        assertEquals(integerList.getHead().next.value, 1);
    }

    @Test
    public void testInsertMethodForMultipleElementListIntoLastIndex() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(10);
        integerList.append(20);
        integerList.append(30);

        assertEquals(integerList.getLength(), 3);

        assertTrue(integerList.insert(3, 40));
        assertEquals(integerList.getLength(), 4);
        assertEquals(integerList.getTail().value, 40);
        assertEquals(integerList.getHead().value, 10);
    }

    @Test
    public void testInsertMethodForMultipleElementList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(10);
        integerList.append(20);
        integerList.append(30);

        assertEquals(integerList.getLength(), 3);

        assertTrue(integerList.insert(2, 25));
        assertEquals(integerList.getLength(), 4);

        assertEquals(integerList.get(2).value, 25);
    }

    @Test
    public void testInsertMethodForNegativeIndex() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(10);
        assertFalse(integerList.insert(-1 , 20));
    }


    @Test
    public void testInsertMethodForIndexMoreThanLength() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(10);
        assertFalse(integerList.insert(3, 20));
    }

    @Test
    public void testRemoveMethodForEmptyList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();
        assertNull(integerList.remove(0));
    }

    @Test
    public void testRemoveMethodForSingleList() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        assertEquals(integerList.remove(0).value, 1);

        assertEquals(integerList.getLength(), 0);
    }

    @Test
    public void testRemoveMethodForMultipleListForIndexZero() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        integerList.append(2);
        integerList.append(3);
        integerList.append(4);

        assertEquals(integerList.remove(0).value, 1);
        assertEquals(integerList.getLength(), 3);
        assertEquals(integerList.getHead().value, 2);
        assertEquals(integerList.getTail().value, 4);
    }

    @Test
    public void testRemoveMethodForMultipleListForLastIndex() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(0);
        integerList.append(1);
        integerList.append(2);
        integerList.append(3);

        assertEquals(integerList.remove(3).value, 3);
        assertEquals(integerList.getLength(), 3);
        assertEquals(integerList.getHead().value, 0);
        assertEquals(integerList.getTail().value, 2);
    }

    @Test
    public void testRemoveMethodForNegativeIndex() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        assertNull(integerList.remove(-2));
    }

    @Test
    public void testRemoveMethodForOutOfBoundsIndex() {
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>(1);
        assertNull(integerList.remove(2));

    }
}
